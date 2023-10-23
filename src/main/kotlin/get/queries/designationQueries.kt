package get.queries

const val getAreaLoc = "SELECT * FROM area_loc_table"
const val insertAreaLocation = "INSERT INTO area_loc_table (area_loc_name, floor_id_relation) VALUES (?, ?)"

const val getDestination = "SELECT * FROM floor_area_table"
const val insertDestination = "INSERT INTO floor_area_table (floor_name) VALUES (?)"
