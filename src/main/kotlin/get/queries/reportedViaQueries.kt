package get.queries


const val reportedViaQuery = "SELECT * FROM reported_via_table"
const val liveReportedViaQuery = "SELECT * FROM reported_via_table WHERE reported_via_name LIKE ?"

const val insertReportedViaQuery = "INSERT INTO reported_via_table (reported_via_name) VALUES (?)"