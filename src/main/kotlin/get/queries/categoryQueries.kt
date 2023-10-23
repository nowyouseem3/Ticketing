package get.queries

const val getMutableSubCategory = "SELECT * FROM sub_category_table WHERE category_id_relation = ?"

const val getCategory = "SELECT * FROM category_table"
const val insertCategory= "INSERT INTO category_table (category_name) VALUES (?)"

const val getSubCategory = "SELECT * FROM sub_category_table"
const val insertSubCategory= "INSERT INTO sub_category_table (sub_category_name, category_id_relation) VALUES (?, ?)"

const val getAssignedDepartment = "SELECT * FROM assigned_department_table"
const val insertAssignedDepartment = "INSERT INTO assigned_department_table (sub_category_id, assign_department_name) VALUES (?, ?)"