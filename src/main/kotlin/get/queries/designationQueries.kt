package get.queries

const val getAreaLoc = "SELECT * FROM area_loc_table"
const val getLiveAreaLoc = "" +
        "SELECT DISTINCT " +
        "area_id, area_loc_name " +
        "FROM " +
        "designation_table, area_loc_table " +
        "WHERE " +
        "designation_table.area_id = area_loc_table.area_loc_id and " +
        "area_loc_table.area_loc_name LIKE ?"
const val getAllLiveAreaLoc = "" +
        "SELECT DISTINCT " +
        "area_id, area_loc_name " +
        "FROM " +
        "designation_table, area_loc_table " +
        "WHERE " +
        "designation_table.area_id = area_loc_table.area_loc_id"
const val getLiveAllFloor = "" +
        "SELECT DISTINCT " +
        "designation_table.floor_id, floor_name, area_id " +
        "FROM " +
        "designation_table, floor_area_table " +
        "WHERE " +
        "designation_table.floor_id = floor_area_table.floor_id and " +
        "area_id = ?"
const val getLiveFloor = "" +
        "SELECT DISTINCT " +
        "designation_table.floor_id, floor_name, area_id " +
        "FROM " +
        "designation_table, floor_area_table " +
        "WHERE " +
        "designation_table.floor_id = floor_area_table.floor_id and " +
        "floor_area_table.floor_name LIKE ? and " +
        "designation_table.area_id = ?"
const val insertAreaLocation = "INSERT INTO area_loc_table (area_loc_name, floor_id_relation) VALUES (?, ?)"

const val getDestination = "SELECT * FROM floor_area_table"
const val insertDestination = "INSERT INTO floor_area_table (floor_name) VALUES (?)"

