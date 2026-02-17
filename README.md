# vm-auto-scaling-controller

# VM Auto Provisioning Controller using Virtualization

## Overview
This project implements an infrastructure-level auto-scaling controller that monitors CPU utilization and dynamically starts or suspends virtual machines using VMware automation.

## Key Features
- Real-time CPU monitoring
- Threshold-based scaling logic
- Automated VM start/suspend using vmrun
- Horizontal scaling demonstration
- Infrastructure control using Python

## Architecture
Controller monitors host CPU and manages:
- app-vm-1
- app-vm-2
- app-vm-3

Scaling policy:
- CPU > 70% → Start VM2
- CPU > 85% → Start VM3
- CPU < 25% → Suspend VM3
- CPU < 15% → Suspend VM2

## Technologies Used
- Python
- VMware Workstation
- psutil
- Virtual Machines (Kali Linux)

## Use Case
Demonstrates infrastructure provisioning and virtualization-based scaling logic similar to cloud auto-scaling systems.

## Author
Aditya Gaur
