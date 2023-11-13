package get.queries

const val ticketUpdateToAssigned = "UPDATE request_ticket_table SET assign_to_id = ?, assign_open = 2, time_data = ? WHERE ticket_id = ?"

const val ticketUpdateToResolved = "UPDATE request_ticket_table SET assign_open = 3, time_data = ? WHERE ticket_id = ?"