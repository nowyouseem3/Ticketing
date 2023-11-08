package get.queries

const val getUser = "SELECT * FROM user_info.user_info_table "
const val getLiveUser = "SELECT * FROM user_info.user_info_table WHERE first_name LIKE ? or last_name LIKE ?"

const val getRequester = "SELECT * FROM requestor_table"

const val insertRequester = "INSERT INTO requestor_table (requester_fname, requester_lname, user_id) VALUES (?, ?, ?)"

const val getToSupport = "SELECT * FROM requestor_table"