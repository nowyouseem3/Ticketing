package get.queries

const val getCategory = "SELECT * FROM category_table"
const val getLiveCategory = "SELECT * FROM category_table WHERE category_name LIKE ?"
const val insertCategory= "INSERT INTO category_table (category_name) VALUES (?)"

const val getNestedSubCategory = "" +
        "SELECT " +
        "sub_category_name, sub_category_id, assign_department_name, assign_department_id " +
        "FROM " +
        "sub_category_table, assigned_department_table " +
        "WHERE " +
        "sub_category_table.assign_department_id = assigned_department_table.assigned_department_id and " +
        "category_id_relation = ?"
const val getSubCategory = "SELECT * FROM sub_category_table"

const val insertSubCategory= "INSERT INTO sub_category_table (sub_category_name, category_id_relation, assign_department_id) VALUES (?, ?, ?)"
const val updateSubCategory= "UPDATE sub_category_table SET assign_department_id = ?, category_id_relation = ? WHERE sub_category_name = ?"

const val getAssignedDepartment = "SELECT * FROM assigned_department_table"
const val getLiveAssignedDepartment = "SELECT department_id, department_name FROM user_info.department_info_table WHERE department_name LIKE ?"
const val insertAssignedDepartment = "INSERT INTO assigned_department_table (assign_department_name) VALUES (?)"