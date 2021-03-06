$(document).ready(function () {
    $('#groupsTable').DataTable();
    $('#usersTable').DataTable();
    $('.dataTables_length').addClass('bs-select');
});

function showModal(modalid) {
    $('#' + modalid).modal("show");
}

function adminEditUser(userid) {
    var editUserModal = $("#editUserModal");
    editUserModal.find('#externalId').val($("#"+userid).find("#userExternalId").html());
    editUserModal.find('#fname').val($("#"+userid).find("#userFirstName").html());
    editUserModal.find('#lname').val($("#"+userid).find("#userLastName").html());
    editUserModal.find('#phNumber').val($("#"+userid).find("#userPhNumber").html());
    editUserModal.find('#group').children("option[value=" + data + "]").attr('selected', 'selected');
    editUserModal.modal("show");
}

function adminSaveUser() {
    $.post("/admin/saveUser", {
        userExternalId: $("#editUserModal").find('#externalId').val(),
        firstName: $("#editUserModal").find('#fname').val(),
        lastName: $("#editUserModal").find('#lname').val(),
        phoneNumber: $("#editUserModal").find('#phNumber').val(),
        groupId: $("#editUserModal").find('#group').children("option:selected").val()
    });
}

function adminRemoveUser(userid) {
    $.post("/admin/removeUser", {
        userId: userid
    }, function () {
        console.log("done removing user");
    });
}

function adminRemoveOrder(orderid) {
    $.post("/order/remove", {
        orderId: orderid
    });
}

function showEditOrderModal(orderid) {
    var editModal = $("#editOrderModal");
    editModal.find('#orderId').val($("#"+orderid).find("#orderId").html());
    editModal.find('#customerId').val($("#"+orderid).find("#customerId").html());
    editModal.find('#customerName').val($("#"+orderid).find("#customerName").html());
    editModal.find('#price').val($("#"+orderid).find("#price").html());
    editModal.modal("show");
}

function updateOrder() {
    $.post("/order/update", {
        orderId: $('#editOrderModal').find("#orderId").val(),
        price: $('#editOrderModal').find("#price").val()
    });
}

function addGroup() {
    var groupName = $('#newGroupModal').find('#gname').val();
    var groupType = $('#newGroupModal').find('#gtype').children("option:selected").val();
    $.post("/group/new", {
        groupName: groupName,
        groupType: groupType
    });
}


function wait(ms){
    var start = new Date().getTime();
    var end = start;
    while(end < start + ms) {
        end = new Date().getTime();
    }
}