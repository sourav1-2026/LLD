package LLD_Khauf_coder.Chain_of_responsibility.Example;

public class example {

    public interface LogLevel {
        int INFO = 1;
        int DEBUG = 2;
        int ERROR = 3;
    }

    public interface Logger{
        void setNext(Logger next);
        void log(String message, int level);
    }

    // Concrete Loggers
    public class InfoLogger implements Logger{

        private Logger next;

        @Override
        public void setNext(Logger next) {
            this.next = next;
        }

        @Override
        public void log(String message, int level) {
            if(level == LogLevel.INFO) {
                System.out.println("INFO: " + message);
            } else if(next != null) {
                next.log(message,level);
            }
        }

    }

    public class DebugLogger implements Logger{

        private Logger next;

        @Override
        public void setNext(Logger next){
            this.next = next;
        }

        @Override
        public void log(String message, int level) {
            if (level == LogLevel.DEBUG) {
                System.out.println("DEBUG: " + message);
            } else if (next != null) {
                next.log(message, level);
            }
        }

    }

    public static void main(String[] args) {
        example example = new example();

        Logger infoLogger = example.new InfoLogger();
        Logger debugLogger = example.new DebugLogger();

        infoLogger.setNext(debugLogger);

        infoLogger.log("This is an info message", LogLevel.INFO);
        infoLogger.log("This is a debug message", LogLevel.DEBUG);
    }
}
