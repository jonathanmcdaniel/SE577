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