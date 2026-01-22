# 🛡️ Ravn-Guard-Sentinel

![Security](https://img.shields.io/badge/Security-Enterprise-red?style=for-the-badge&logo=shield&logoColor=white)
![Netty](https://img.shields.io/badge/Netty-Native%20Injection-grey?style=for-the-badge&logo=netty&logoColor=white)
![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![License](https://img.shields.io/badge/License-Proprietary-blue?style=for-the-badge)

> **"The First Line of Defense."**
> A kernel-level packet filtering system designed to neutralize attacks before they reach the main thread.

**Ravn-Guard-Sentinel** operates directly within the Netty pipeline, injecting custom channel handlers to analyze incoming traffic byte-by-byte. Unlike standard plugins, Sentinel drops malicious packets at the socket level, ensuring zero performance impact on the server tick loop.

### ⚔️ Defense Capabilities
* **Netty Injection:** Intercepts traffic at the lowest level possible in the JVM.
* **NullPing Mitigation:** Automatically closes connections that send malformed handshake packets.
* **Packet Limiter:** Intelligent rate-limiting per IP to prevent packet flood exploits.
* **Decoder Analysis:** Detects and blocks illegal NBT tags that cause server crashes (Book exploits, heavy items).

### ⚙️ Configuration (sentinel.yml)

```yaml
security-level: HIGH # LOW, MEDIUM, HIGH, PARANOID

packet-filter:
  max-packets-per-sec: 50
  block-unknown-payloads: true
  
firewall:
  geo-block:
    - "CN" # China
    - "RU" # Russia
  whitelist-mode: false

alerts:
  webhook: "[https://discord.com/api/webhooks/](https://discord.com/api/webhooks/)..."
  notify-admins: true
