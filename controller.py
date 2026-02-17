import time
import os
import psutil

VMRUN = r"Vmrun path give here which u find in your C drive"

VM2 = r"VirtualMachinespath u have to give here which end like -->\app-vm-2\app-vm-2.vmx"
VM3 = r"VirtualMachinespath u have to give here which end like -->\app-vm-3\app-vm-3.vmx"

UPPER = 70
VERY_HIGH = 85
LOWER = 25
VERY_LOW = 15

CHECK_INTERVAL = 5

vm2_running = False
vm3_running = False


def cpu_usage():
    return psutil.cpu_percent(interval=1)


def start_vm(path):
    os.system(f'"{VMRUN}" start "{path}"')

def suspend_vm(path):
    os.system(f'"{VMRUN}" suspend "{path}"')


while True:
    cpu = cpu_usage()
    print(f"CPU: {cpu:.2f}%")

    if cpu > UPPER and not vm2_running:
        print("Starting VM2")
        start_vm(VM2)
        vm2_running = True

    if cpu > VERY_HIGH and not vm3_running:
        print("Starting VM3")
        start_vm(VM3)
        vm3_running = True

    if cpu < LOWER and vm3_running:
        print("Suspending VM3")
        suspend_vm(VM3)
        vm3_running = False

    if cpu < VERY_LOW and vm2_running:
        print("Suspending VM2")
        suspend_vm(VM2)
        vm2_running = False

    time.sleep(CHECK_INTERVAL)
