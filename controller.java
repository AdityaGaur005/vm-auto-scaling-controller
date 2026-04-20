import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class AutoScaleVM {

    // Give your vmrun.exe full path here
    static String VMRUN = "C:\\Path\\To\\vmrun.exe";

    // Give your .vmx file paths here
    static String VM2 = "C:\\VirtualMachines\\app-vm-2\\app-vm-2.vmx";
    static String VM3 = "C:\\VirtualMachines\\app-vm-3\\app-vm-3.vmx";

    static final int UPPER = 70;
    static final int VERY_HIGH = 85;
    static final int LOWER = 25;
    static final int VERY_LOW = 15;

    static final int CHECK_INTERVAL = 5; // seconds

    static boolean vm2Running = false;
    static boolean vm3Running = false;

    public static void main(String[] args) {
        while (true) {
            double cpu = getCpuUsage();
            System.out.printf("CPU: %.2f%%%n", cpu);

            try {
                if (cpu > UPPER && !vm2Running) {
                    System.out.println("Starting VM2");
                    startVM(VM2);
                    vm2Running = true;
                }

                if (cpu > VERY_HIGH && !vm3Running) {
                    System.out.println("Starting VM3");
                    startVM(VM3);
                    vm3Running = true;
                }

                if (cpu < LOWER && vm3Running) {
                    System.out.println("Suspending VM3");
                    suspendVM(VM3);
                    vm3Running = false;
                }

                if (cpu < VERY_LOW && vm2Running) {
                    System.out.println("Suspending VM2");
                    suspendVM(VM2);
                    vm2Running = false;
                }

                TimeUnit.SECONDS.sleep(CHECK_INTERVAL);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Get CPU usage %
    public static double getCpuUsage() {
        OperatingSystemMXBean osBean =
                (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double load = osBean.getSystemCpuLoad();

        if (load < 0) {
            return 0;
        }

        return load * 100;
    }

    // Start VM
    public static void startVM(String path) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(VMRUN, "start", path);
        pb.inheritIO();
        pb.start();
    }

    // Suspend VM
    public static void suspendVM(String path) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(VMRUN, "suspend", path);
        pb.inheritIO();
        pb.start();
    }
}v
