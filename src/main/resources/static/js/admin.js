$(document).ready(function () {
    $('#groupsTable').DataTable();
    $('#usersTable').DataTable();
    $('.dataTables_length').addClass('bs-select');
});

function showModal(modalid) {
    $('#' + modalid).modal("show");
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