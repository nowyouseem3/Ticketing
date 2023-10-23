package get.queries

const val assignToQuery = "SELECT * FROM assign_to_table"
const val insertAssignToQuery = "INSERT INTO assign_to_table (assign_to_name) VALUES (?)"

const val coAssignToQuery = "SELECT * FROM assign_to_table WHERE assign_to_id != ?"