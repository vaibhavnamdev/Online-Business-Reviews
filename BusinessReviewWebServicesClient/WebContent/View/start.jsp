	<div align="center">
		<table border="0">
			<tr>
				<td colspan="2" align="center"><h2>User Details</h2></td>
			</tr>
			
		
		</table>

		<table border="1px" bordercolor="black" width=100% align="center">
			<tr align="center">
				<td>User Id</td>
				<td>User Location</td>
				<td>OS Requested</td>
				<td>RAM Requested(in MB)</td>
				<td>Storage Requested(in GB)</td>
				<td>Bandwidth Requested(in Mbps)</td>
				<td>Cloud Allocated ? </td>
				<td>Cloud Location </td>
				<td>Instance Created Time</td>
				<td>Instance Termination Time</td>
				<td>Total Charges(in $) </td>
				
				
				
			</tr>
			<c:forEach items="${userForm.listUser}" var="element">

				<tr align="center">
					<td><c:out value="${element.userId}" /></td>
					<c:if test = "${element.userLocationId == '01'}">
						<td>North</td>
					</c:if>
					<c:if test = "${element.userLocationId == '02'}">
						<td>South</td>
					</c:if>
					<c:if test = "${element.userLocationId == '03'}">
						<td>East</td>
					</c:if>
					<c:if test = "${element.userLocationId == '04'}">
						<td>West</td>
					</c:if>
					<td><c:out value="${element.os}" /></td>
					<td><c:out value="${element.ramRequested}" /></td>
					<td><c:out value="${element.storageRequested}" /></td>
					<td><c:out value="${element.bandwidthRequested}" /></td>
					<td><c:out value="${element.allocated}" /></td>
					
					<c:if test = "${element.zoneLocationId == '01'}">
						<td>North</td>
					</c:if>
					<c:if test = "${element.zoneLocationId == '02'}">
						<td>South</td>
					</c:if>
					<c:if test = "${element.zoneLocationId == '03'}">
						<td>East</td>
					</c:if>
					<c:if test = "${element.zoneLocationId == '04'}">
						<td>West</td>
					</c:if>
					<td><c:out value="${element.instanceStartedTime}" /></td>
					<td><c:out value="${element.instanceKilledTime}" /></td>
					<td><c:out value="${element.charges}" /></td>
					
				</tr>

			</c:forEach>
		</table>

	</div>