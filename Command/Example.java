package LLD_Khauf_coder.Command;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Example {

    public interface TaskCommand{
        void execute();
        void undo();
    }

    // Receiver class

    public class EmailService{
        public void sendEmail(String message){
            System.out.println("Sending email: " + message);
        }

        public void deleteEmail(String message){
            System.out.println("Deleting email: " + message);
        }
    }

    public class ReportService{
        public void generateReport(String reportName){
            System.out.println("Generating report: " + reportName);
        }

        public void deleteReport(String reportName){
            System.out.println("Deleting report: " + reportName);
        }
    }

    // Concrete Command classes

    public class EmailTask implements TaskCommand{

        private EmailService emailService;

        public EmailTask(EmailService emailService){
            this.emailService = emailService;
        }

        @Override
        public void execute() {
            emailService.sendEmail("Hello, this is a command pattern example from Send Email!");
        }

        @Override
        public void undo() {
            emailService.deleteEmail("Hello, this is a command pattern example from Delete Email!");
        }
    }

    public class ReportTask implements TaskCommand{

        private ReportService reportService;

        public ReportTask(ReportService reportService){
            this.reportService = reportService;
        }

        @Override
        public void execute() {
            reportService.generateReport("Sales Report");
        }

        @Override
        public void undo() {
            reportService.deleteReport("Sales Report");
        }
    }


    class TaskShecdular{
        private Queue<TaskCommand> taskCommands=new LinkedList<>();
        private Stack<TaskCommand> history=new Stack<>();

        public void addTask(TaskCommand taskCommand){
            taskCommands.offer(taskCommand);
        }

        public void executeTasks(){
            while(!taskCommands.isEmpty()){
                TaskCommand taskCommand=taskCommands.poll();
                taskCommand.execute();
                history.push(taskCommand);
            }
        }

        public void undoLastTask(){
            if(!history.isEmpty()){
                TaskCommand lastCommand=history.pop();
                lastCommand.undo();
            }
        }
    }

}
