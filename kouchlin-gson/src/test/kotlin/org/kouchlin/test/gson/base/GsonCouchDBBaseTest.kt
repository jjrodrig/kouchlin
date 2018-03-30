package org.kouchlin.test.gson.base

import org.junit.AfterClass
import org.junit.BeforeClass
import org.kouchlin.CouchDB
import org.kouchlin.gson.GsonJsonAdapter

open class GsonCouchDBBaseTest {
	companion object {
		lateinit var couchdb: CouchDB

		@BeforeClass
		@JvmStatic
		fun setUpClass() {
			CouchDB.adapter = GsonJsonAdapter()
			couchdb = CouchDB("http://127.0.0.1:5984")
			couchdb.database("kouchlin-test-db").create()
		}

		@AfterClass
		@JvmStatic
		fun teardown() {
			couchdb.database("kouchlin-test-db").delete()
			couchdb.database("kouchlin-changes-test-db").delete()
			couchdb.database("kouchlin-test-alldocs-db").delete()
			couchdb.database("kouchlin-target-db").delete()
		}

	}
}