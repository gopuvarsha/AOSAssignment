package mutex;
import java.io.OutputStream;
import java.rmi.*;
import java.rmi.server.*;
import java.util.HashMap;

class Competition extends UnicastRemoteObject implements CompetitionInterface {


int noOfParticipants;			  // number of participants in the competition
int noOfResources;				  // total number of resources
Map<int, String> studentsMap;				    // list of students and their IP addresses
Resource resource_list[4];				  // list of resources 

public:

Competition() {

noOfParticipants = 0;
noOfResources = 4;

studentsMap = new HashMap<int,String>();
resource_list[0]=new Resource('Pencil','true',NONSHARED);
resource_list[1]=new Resource('Chart','true',NONSHARED);
resource_list[2]=new Resource('Scale','true',NONSHARED);
resource_list[3]=new Resource('Eraser','false',SHARED);


}
void startCompetition() {
String stu_ip;
for (String value : students.values()) {
  stu_ip = value;
  StudentInterface student=(StudentInterface)Naming.lookup("//" +stu_ip + "/StudentInterface");
  student.AssignStudentsMap(studentsMap);


}
}		
int getId(String ip) throws RemoteException {

try{	
	noOfParticipants += 1;
	studentsMap.put(noOfParticipants, ip);
	} catch (Exception e) { System.out.println("Exception:" + e.getMessage()) }
	return noOfParticipants;
	
}

    
           // Use to allocate unique ID to students (processes) 
Resource[] getResources throws RemoteException() {

 return resource_list;
}		  // Allocates resources to each student
HashMap getStudents throws RemoteException() {

return studentsMap;
}

}
