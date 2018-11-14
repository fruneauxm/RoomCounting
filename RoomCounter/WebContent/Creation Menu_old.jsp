<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width,initial-scale=1">
      <title>Initialization UI</title>
      <link rel="stylesheet" href="css/bootstrap4.min.css">
      <link rel="stylesheet" href="css/wireframe-theme.min.css">
      <link rel="stylesheet" href="css/main.css">
      	</head>
      <!-- nav -->
      <div class="row">
         <nav class="col-xs-12 breadcrumb">
            <a class="link-text breadcrumb-item" href="#">Initialize Data</a>
            <a class="link-text breadcrumb-item" href="#">Link</a>
            <a class="link-text breadcrumb-item" href="#">Link</a>
            <a class="link-text breadcrumb-item" href="#">Link</a>
            <nav class="container-fluid"></nav>
         </nav>
      </div>
      <div class="row">
         <div class="col-xs-12 col-lg-12">
               <h1 class="heading-1">Initialize Database</h1>
         </div>
         <div class="col-xs-12 col-lg-12">
               <span class="text-element small-heading">Name:&nbsp</span>
               <input  name="name" type="text" onkeypress="setName(this.value)" required>
               
         </div>
      </div>
      <br>
      <br>
      <div class="row">
         <div class="col-xs-12 col-md-6 col-lg-6 column-2 col-sm-6">
         
         <!--  URLs for form methods -->
         	<c:url value="/addSession" var="addSessionURL"></c:url>
         	<c:url value="/addTimeSlot" var="addTimeSlotURL"></c:url>
         	<c:url value="/addRoomSlot" var="addRoomSlot"></c:url>
         
         
         
         <!-- time slot form -->  
          <form action='<c:out value="${addTimeSlotURL}"></c:out>' method="POST" class="container-fluid container-2">
               <h4 class="large-heading"><span class="heading-text-1">Add Time Slot:</span>
               </h4>
               <span class="text-element small-heading">Start Time:<br>
               </span><input  name="start" type="text" class="input">
               <span class="text-element small-heading">End Time:<br>
               </span><input  name="end" type="text">
               <button type="submit" class="btn" value="Submit">Submit</button>
            </form>

            <!-- room form -->
            <form action='<c:out value="${addRoomSlot}"></c:out>' method="POST" class="container-fluid container-3">
               <h4 class="large-heading"><span class="heading-text-1">Add a Room:</span>
               </h4>
               <span class="text-element small-heading">Room Name:<br>
               </span><input  name="room-name" type="text">
               <span class="text-element small-heading">Capacity:<br>
               </span><input  name="capacity" type="text" class="input-1"><button type="submit" class="btn" value="Submit">Submit</button>
            
			</form>
			<div>
			<%-- Room List Logic --%>
               <c:if test="${not empty requestScope.rooms}">
               <table style="width:100%" style="border:100%">
               			<tr>
               				<th>Room Name</th>
               				<th>Capacity</th>
               				<th>Update</th>
               				<th>Delete</th>
               			</tr>
               			
               			<c:forEach items="${requestScope.rooms}" var="room">
               			<!-- URLS FOR THE BUTTONS -->
               			
               			    <c:url value="/editRoom" var="editRoomURL">
								<c:param name="id" value="${room.roomID}"></c:param>
							</c:url>
						
							<c:url value="/deleteRoom" var="deleteRoomURL">
								<c:param name="id" value="${room.roomID}"></c:param>
							</c:url>
							
               				<tr>
               				<td><c:out value="${room.name}"></c:out></td>		
               				<td><c:out value="${room.capacity}"></c:out></td>	
               				<td><a
							href='<c:out value="${editRoomURL}" escapeXml="true"></c:out>'>Update</a></td>	
               				<td><a
							href='<c:out value="${deleteRoomURL}" escapeXml="true"></c:out>'>Delete</a></td>	
               				</tr>
               			</c:forEach>
               			 
               </table>
              </c:if> 
              </div>
			


            <span class="text-element"></span>
         </div>
         <div class="col-xs-2 column-1 col-md-6 col-lg-6 col-sm-6 custom-284-col-xs-12">

            <!-- session form -->
            <form action='<c:out value="${addSessionURL}"></c:out>' method="post"  class="container-fluid container-1">
               <h4 class="large-heading">Add Session:</h4>
               <span class="text-element small-heading">Session Name:<br>
               </span><input  name="session-name" type="text">
               <span class="text-element small-heading">Session Number:</span>
               <input  name="session-number" type="text">
               <span class="text-element small-heading">Speaker:<br>
               </span><input  name="speaker" type="text">
               <span class="text-element small-heading">Time Slot:&nbsp;</span>
               <select class="select drop-down-1" name="time-slot">
                  <option>Option 1</option>
                  <option>Option 2</option>
                  <option>Option 3</option>
               </select>
               <span class="text-element small-heading">Room:&nbsp;</span>
               <select class="room">
                  <option>Option 1</option>
                  <option>Option 2</option>
                  <option>Option 3</option>
               </select>
               
               <button type="submit" class="btn">Submit</button>
               
            </form>
            <span class="text-element">&nbsp;<br>
            </span>
         </div>
      </div>
   </body>
     <script>
  $(function() {
    $('div#froala-editor').froalaEditor({
      editInPopup: true
    })
  });
</script>
</html>