package get.queries

const val createTicketQuery = "INSERT INTO request_ticket_table (ticket_id, requester_id, to_support_id," +
        "category_id, sub_category_id, area_id, floor_id, reported_via, assign_department_id," +
        "assign_to_id, co_assign_id,time_data,assign_open) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"

const val getTicketCount = "SELECT ticket_row_id FROM request_ticket_table"

const val getAllTickets = "" +
        "SELECT " +
        "request_ticket_table.ticket_id, " +
        "status_name, " +
        "status_code, " +
        "requestor_table.requester_fname, " +
        "requestor_table.requester_lname, " +
        "to_support_table.requester_fname as tosupport_fname, " +
        "to_support_table.requester_lname as tosupport_lname, " +
        "category_name, " +
        "sub_category_name, " +
        "area_loc_name, " +
        "floor_name, " +
        "reported_via_name, " +
        "assign_department_name, " +
        "assign_to_table.assign_to_name, " +
        "assign_to_table.assign_to_lastname, " +
        "co_assign_table.assign_to_name as co_assign_name, " +
        "co_assign_table.assign_to_lastname as co_assign_lastname, " +
        "time_data " +
        "FROM " +
        "request_ticket_table, " +
        "ticket_status_table, " +
        "status_selector, " +
        "requestor_table, " +
        "requestor_table as to_support_table, " +
        "category_table, " +
        "sub_category_table, " +
        "area_loc_table, " +
        "floor_area_table, " +
        "reported_via_table, " +
        "assigned_department_table, " +
        "assign_to_table, " +
        "assign_to_table as co_assign_table " +
        "WHERE " +
        "requestor_table.user_id = request_ticket_table.requester_id and " +
        "to_support_table.user_id = request_ticket_table.to_support_id and " +
        "category_table.category_id = request_ticket_table.category_id and " +
        "sub_category_table.sub_category_id = request_ticket_table.sub_category_id and " +
        "area_loc_table.area_loc_id = request_ticket_table.area_id and " +
        "floor_area_table.floor_id = request_ticket_table.floor_id and " +
        "reported_via_table.reported_via_id = request_ticket_table.reported_via and " +
        "assigned_department_table.assigned_department_id = request_ticket_table.assign_department_id and " +
        "assign_to_table.user_id = request_ticket_table.assign_to_id and " +
        "co_assign_table.user_id = request_ticket_table.co_assign_id and " +
        "status_selector.status_code = ticket_status_table.ticket_status and " +
        "ticket_status_table.ticket_id = request_ticket_table.ticket_id "


