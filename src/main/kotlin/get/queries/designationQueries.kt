package get.queries

const val getAreaLoc = "SELECT * FROM area_loc_table"
const val getLiveAreaLoc = "" +
        "SELECT " +
        "area_loc_name, area_loc_id, floor_id, floor_name " +
        "FROM " +
        "area_loc_table, floor_area_table " +
        "WHERE " +
        "area_loc_table.floor_id_relation = floor_area_table.floor_id AND " +
        "area_loc_name LIKE ?"
const val getAllLiveAreaLoc = "" +
        "SELECT " +
        "area_loc_name, area_loc_id, floor_id, floor_name " +
        "FROM " +
        "area_loc_table, floor_area_table " +
        "WHERE " +
        "area_loc_table.floor_id_relation = floor_area_table.floor_id"
const val insertAreaLocation = "INSERT INTO area_loc_table (area_loc_name, floor_id_relation) VALUES (?, ?)"

const val getDestination = "SELECT * FROM floor_area_table"
const val insertDestination = "INSERT INTO floor_area_table (floor_name) VALUES (?)"

