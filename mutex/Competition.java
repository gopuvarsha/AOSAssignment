package mutex;
import java.io.OutputStream;
import java.rmi.*;
import java.rmi.server.*;
import java.util.HashMap;

class Competition extends UnicastRemoteObject implements CompetitionInterface {


int noOfParticipants;			  // number of participants in the competition
int noOfResources;				  // total number of resources
Map<int, String> studentsMap;				    // list of students and their IP addresses
				  // list of resources 

public:

Competition() {

noOfParticipants = 0;
noOfResources = 4;

studentsMap = new HashMap<int,String>();




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

noOfParticipants += noOfParticipants;
studentsMap.put(noOfParticipants, ip);
return noOfParticipants;

}     
           // Use to allocate unique ID to students (processes) 
HashMap getResources throws RemoteException() {}		  // Allocates resources to each student
HashMap getStudents throws RemoteException() {}

}
