function deleteTimeSlot() {
	var selected = $("#timeSlotSelect").children("option:selected");
	selected.remove();
	// communicate to db that entry needs to be removed
}

function deleteRoom() {
	// todo
	// communicate to db that entry needs to be removed
}

function deleteSession() {
	// todo
	// communicate to db that entry needs to be removed
}

function modifyTimeSlot() { // called by modify button
	var selected = $("#timeSlotSelect").children("option:selected").text()
	.split("-");
	var start = $("input[name='start']");
	start.val(selected[0]);
	var end = $("input[name='end']");
	end.val(selected[1]);
	// communicate to db the changes that occur
}

function modifyRoom() { // called by modify button
	var selected = $("#roomSelect").children("option:selected").text()
	.split(";");
	var roomname = $("input[name='room-name']");
	roomname.val(selected[0].toString().replace(" Roomname:",""));
	var capacity = $("input[name='capacity']");
	capacity.val(selected[1].toString().replace(" Capacity:",""));
	// communicate to db the changes that occur
}

function modifySession() { // called by modify button
	var selected = $("#sessionSelect").children("option:selected").text()
	.split(";");
	var name = $("input[name='session-name']");
	name.val(selected[0].toString().replace(" Session Name:",""));
	var number = $("input[name='session-number']");
	number.val(selected[1].toString().replace(" Session Number:",""));
	var speaker = $("input[name='speaker']");
	speaker.val(selected[2].toString().replace(" Speaker:",""));
	var date = $("input[name='date']");
	var splitDate = selected[3].toString().replace(" Date:","").split("/");
	date.val(new Date(splitDate[2],splitDate[0]-1,splitDate[1]));
	//var timeslot = $("input[name='time-slot']");
	//timeslot.val(selected[4].toString().replace(" Time Slot:",""));
	//var room = $("input[name='room']");
	//room.val(selected[5].toString().replae( "Room:",""));
	// communicate to db the changes that occur
}
//"id":"1" ,"name":"sA" , "number":"1" , "speaker":"sp1" , "date":"11/17/2018" , "timeslot":"12:00-14:00" , "room":"A"

function displayTimeSlots(json) {
	var obj = JSON.parse(json);

	var output = '<select id="timeSlotSelect" class="dynam-select" multiple>';
	var count = 0;
	for ( var i in obj.timeslot) {
		output += '<option value=' + obj.timeslot[count].id + '>'
		+ obj.timeslot[count].start + '-' + obj.timeslot[count].end
		+ '</option>';
		count++;
	}
	output += "</select>";

	$('#curTimeSlots').append(output);
}

function displayRooms(json) {
	var obj = JSON.parse(json);

	var output = '<select id="roomSelect" class="dynam-select" multiple>';
	var count = 0;
	for ( var i in obj.room) {
		output += '<option value=' + obj.room[count].id + '> Roomname:'
		+ obj.room[count].roomname + '; Capacity:' + obj.room[count].capacity
		+ '</option>';
		count++;
	}
	output += "</select>";

	$('#curRooms').append(output);
}

function displaySessions(json) {
	var obj = JSON.parse(json);

	var output = '<select id="sessionSelect" class="dynam-select" multiple>';
	var count = 0;
	for ( var i in obj.session) {
		output += '<option value=' + obj.session[count].id + '> Session Name:'
		+ obj.session[count].name + '; Session Number:' + obj.session[count].number
		+ '; Speaker:' + obj.session[count].speaker + '; Date:' + obj.session[count].date
		+ '; Time Slot:' + obj.session[count].timeslot + '; Room:' + obj.session[count].room
		+ '</option>';
		count++;
	}
	output += "</select>";

	$('#curSessions').append(output);
}
/*
function createTimeSlotDropdown() {
	var selected = $("#timeSlotSelect").children("option:selected").text();
	
	var output = <select name="room">;
	var count = 0;
	for(var i in selected)
	{
		output += '<option>' + selected[count] + '</option>';
	}
	output += </select>
	
	$('#timeDropdown').append(output);
}
*/
function createRoomDropdown() {
	// todo
}

$(document).ready(
		function() {

			// connection to db needs to happen to get data for display
			// we need to
			// 1. put timeslots and rooms into the options menu of session
			// 2. populate the modification containers (as I have done for time
			// slot) (needs to be done for session and room)
			var text = '{ "timeslot" : ['
				+ '{ "id":"1" ,"start":"12:00" , "end":"14:00" },'
				+ '{ "id":"2" ,"start":"9:00" , "end":"12:00" },'
				+ '{ "id":"3" ,"start":"10:00" , "end":"12:00" },'
				+ '{ "id":"4" ,"start":"9:00" , "end":"12:00" },'
				+ '{ "id":"5" ,"start":"13:00" , "end":"12:00" },'
				+ '{ "id":"6" ,"start":"9:00" , "end":"19:00" },'
				+ '{ "id":"7" ,"start":"19:00" , "end":"12:00" },'
				+ '{ "id":"8" ,"start":"17:00" , "end":"12:00" },'
				+ '{ "id":"9" ,"start":"9:00" , "end":"18:00" },'
				+ '{ "id":"12" ,"start":"10:00" , "end":"12:00" },'
				+ '{ "id":"11" ,"start":"9:00" , "end":"12:00" },'
				+ '{ "id":"13" ,"start":"12:00" , "end":"16:00" },'
				+ '{ "id":"14" ,"start":"9:00" , "end":"12:00" },'
				+ '{ "id":"10" ,"start":"14:00" , "end":"15:00" } ]}';

			var text2 = '{ "room" : ['
				+ '{ "id":"1" ,"roomname":"A" , "capacity":"14" },'
				+ '{ "id":"2" ,"roomname":"B" , "capacity":"12" },'
				+ '{ "id":"3" ,"roomname":"C" , "capacity":"12" },'
				+ '{ "id":"4" ,"roomname":"D" , "capacity":"12" },'
				+ '{ "id":"5" ,"roomname":"E" , "capacity":"12" },'
				+ '{ "id":"6" ,"roomname":"F" , "capacity":"19" },'
				+ '{ "id":"7" ,"roomname":"G" , "capacity":"12" },'
				+ '{ "id":"8" ,"roomname":"H" , "capacity":"12" },'
				+ '{ "id":"9" ,"roomname":"I" , "capacity":"18" },'
				+ '{ "id":"12" ,"roomname":"J" , "capacity":"12" },'
				+ '{ "id":"11" ,"roomname":"K" , "capacity":"12" },'
				+ '{ "id":"13" ,"roomname":"L" , "capacity":"16" },'
				+ '{ "id":"14" ,"roomname":"M" , "capacity":"12" },'
				+ '{ "id":"10" ,"roomname":"N" , "capacity":"15" } ]}';
				
			var text3 = '{ "session" : ['
				+ '{ "id":"1" ,"name":"sA" , "number":"1" , "speaker":"sp1" , "date":"11/17/2018" , "timeslot":"12:00-14:00" , "room":"A" },'
				+ '{ "id":"2" ,"name":"sB" , "number":"2" , "speaker":"sp2" , "date":"11/17/2018" , "timeslot":"14:00-16:00" , "room":"B" },'
				+ '{ "id":"3" ,"name":"sC" , "number":"3" , "speaker":"sp3" , "date":"11/17/2018" , "timeslot":"09:00-11:00" , "room":"C" },'
				+ '{ "id":"4" ,"name":"sD" , "number":"4" , "speaker":"sp4" , "date":"11/18/2018" , "timeslot":"10:00-13:00" , "room":"D" },'
				+ '{ "id":"5" ,"name":"sE" , "number":"5" , "speaker":"sp5" , "date":"11/18/2018" , "timeslot":"13:00-15:00" , "room":"E" },'
				+ '{ "id":"6" ,"name":"sF" , "number":"6" , "speaker":"sp6" , "date":"11/17/2018" , "timeslot":"12:00-15:00" , "room":"F" },'
				+ '{ "id":"7" ,"name":"sG" , "number":"7" , "speaker":"sp7" , "date":"11/18/2018" , "timeslot":"14:00-17:00" , "room":"G" } ]}';

			displayTimeSlots(text);
			//displayRooms(text2);
			displaySessions(text3);
			//createTimeSlotDropdown();

		});
