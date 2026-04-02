# ⚙️ VM Auto-Scaling Controller

## 🚀 VM Auto Provisioning using Virtualization

An infrastructure-level auto-scaling controller that monitors system CPU usage and dynamically starts or suspends virtual machines using VMware automation.

> This project simulates how cloud platforms (like AWS Auto Scaling) manage resources — but implemented locally using virtualization.

---

## 🧠 Overview

This system continuously monitors host CPU utilization and makes real-time scaling decisions by controlling virtual machines.

Instead of manual provisioning, the controller:
- Detects system load  
- Applies scaling policies  
- Automatically manages VM lifecycle  

---

## ✨ Key Features

- 📊 Real-time CPU monitoring  
- ⚖️ Threshold-based scaling logic  
- 🖥️ Automated VM start/suspend using `vmrun`  
- 🔁 Horizontal scaling simulation  
- 🧩 Infrastructure control using Python  

---

## 🏗️ Architecture

The controller monitors host CPU and manages multiple virtual machines:

- app-vm-1 (always running)  
- app-vm-2 (scales up/down)  
- app-vm-3 (scales up/down)  

---

## 📈 Scaling Policy

| CPU Usage        | Action            |
|-----------------|------------------|
| > 70%           | Start VM2        |
| > 85%           | Start VM3        |
| < 25%           | Suspend VM3      |
| < 15%           | Suspend VM2      |

---

## ⚙️ Technologies Used

- Python  
- VMware Workstation  
- `psutil` (CPU monitoring)  
- Virtual Machines (Kali Linux)  

---

## 🔄 How It Works

1. Monitor CPU usage using `psutil`  
2. Evaluate against defined thresholds  
3. Trigger VM operations using `vmrun`  
4. Maintain optimal resource utilization  

---

## 🎯 Use Case

This project demonstrates:

- Infrastructure automation  
- Virtualization-based scaling  
- Core concepts of cloud auto-scaling systems  

> A strong foundation for understanding tools like AWS Auto Scaling, Kubernetes HPA, and cloud orchestration.

---

## 📌 Why This Project Stands Out

- Simulates real-world cloud scaling logic  
- Works at infrastructure level (not just application level)  
- Demonstrates DevOps + virtualization skills  
- Shows system-level thinking  

---

## 🔮 Future Improvements

- Add logging & monitoring dashboard  
- Integrate with cloud (AWS / GCP)  
- Add predictive scaling using ML  
- Container-based scaling (Docker + Kubernetes)  

---

## 👨‍💻 Author

**Aditya Gaur**  
BTech | Cloud & DevOps Enthusiast  

---

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.
