# 📸 Camera & Gallery App

![Kotlin](https://img.shields.io/badge/Kotlin-1.9%2B-blue?logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-24%2B%20(min)-brightgreen?logo=android&logoColor=white)
![Target](https://img.shields.io/badge/Target%20SDK-34-informational)
![License](https://img.shields.io/badge/License-MIT-yellow)

> A simple Android app built with Kotlin that demonstrates how to **take photos**, **record videos**, and **select multiple images from the gallery** using modern **Activity Result APIs** and **runtime permissions**.

---

## 🧭 Overview

This project is part of the **FactCampus Android Learning Series (Part 1)**.  
It demonstrates how to:

- Capture photos using the **Camera**
- Record videos using the **Video Recorder**
- Pick multiple images from the **Gallery**
- Request and handle **Android 13+ permissions** (`READ_MEDIA_IMAGES`, `READ_MEDIA_VIDEO`)
- Implement clean and modern **Kotlin** code with **ViewBinding**

---

## 🖼️ Screenshots

<div align="center">
  <img src="image1.png" alt="Camera Screen" width="30%">
  <img src="image2.png" alt="Video Screen" width="30%">
  <img src="image3.png" alt="Gallery Screen" width="30%">
  <img src="image4.png" alt="Gallery Screen" width="30%">
  <img src="image5.png" alt="Gallery Screen" width="30%">
  <img src="image6.png" alt="Gallery Screen" width="30%">
</div>

> 📱 App screenshots — showing Camera, Video, and Gallery features

---

## 🚀 Features

- 📷 Capture photos with `MediaStore.ACTION_IMAGE_CAPTURE`
- 🎥 Record videos with `MediaStore.INTENT_ACTION_VIDEO_CAMERA`
- 🖼️ Select multiple images using `ActivityResultContracts.GetMultipleContents`
- 🔐 Smart runtime permission handling for all Android versions
- ⚡ Uses `ActivityResultContracts` instead of deprecated `onActivityResult`

---

## 🧰 Tech Stack

| Category | Technology |
|-----------|-------------|
| **Language** | Kotlin |
| **UI** | XML Layout + ViewBinding |
| **Permissions** | AndroidX Core + AlertDialog |
| **SDK** | Min SDK 24 / Target SDK 34 |
| **Build Tools** | Gradle (KTS compatible) |

---

## 🗂️ Project Structure
