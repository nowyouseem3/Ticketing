package get.queries

const val assignToQuery = "SELECT * FROM assign_to_table"

const val liveAssignToQuery = "" +
        "SELECT " +
        "last_name, first_name, user_info.user_info_table.user_id, department_id, availability " +
        "FROM " +
        "user_info.user_info_table, user_info.user_designation_table, " +
        "public.support_availability " +
        "WHERE " +
        "user_info.user_info_table.user_id = user_info.user_designation_table.user_id and " +
        "public.support_availability.user_id = user_info.user_info_table.user_id and " +
        "department_id = ? and last_name LIKE ? or first_name LIKE ? and " +
        "user_info.user_info_table.user_id = user_info.user_designation_table.user_id and " +
        "department_id = ? and " +
        "support_availability.availability = 0"
const val liveAllAssignToQuery = "" +
        "SELECT " +
        "last_name, first_name, user_info.user_info_table.user_id, department_id, availability " +
        "FROM " +
        "user_info.user_info_table, user_info.user_designation_table, public.support_availability " +
        "WHERE " +
        "user_info.user_info_table.user_id = user_info.user_designation_table.user_id and " +
        "public.support_availability.user_id = user_info.user_info_table.user_id and " +
        "department_id = ? and " +
        "support_availability.availability = 0"

const val insertAssignToQuery = "INSERT INTO assign_to_table (assign_to_name, assign_to_lastname, user_id) VALUES (?, ?, ?)"

const val coAssignToQuery = "SELECT * FROM assign_to_table WHERE assign_to_id != ?"
