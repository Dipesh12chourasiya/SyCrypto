# SyCrypto

SyCrypto is a cryptocurrency tracker app that fetches and displays real-time data about cryptocurrencies using the CoinMarketCap API. Users can view detailed information, including the name, symbol, and current price of various cryptocurrencies, and use the search feature to filter results dynamically.

---

## APK Link
"https://drive.google.com/file/d/1-ydfXilVw8fhTU7wmOua2FxHx-hONnDd/view?usp=sharing"

## Features

- **Live Data Fetching**: Fetches real-time cryptocurrency data from the CoinMarketCap API.
- **Search Functionality**: Provides a responsive search bar to filter cryptocurrencies by name.
- **RecyclerView Integration**: Displays data in a structured list format with smooth scrolling.
- **Progress Indicator**: Shows a loading indicator while data is being fetched.
- **Error Handling**: Handles API errors gracefully by showing user-friendly messages.

---

## Prerequisites

Before setting up the project, ensure you have the following installed:

- **Android Studio** (latest version recommended)
- **Android SDK**
- An active **CoinMarketCap API key**

---

## Setup Instructions

Follow these steps to set up and run the SyCrypto app:

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/sycrypto.git
cd sycrypto
```

### 2. Open in Android Studio
1. Launch **Android Studio**.
2. Click on **File > Open** and navigate to the project folder.
3. Let Android Studio sync the Gradle files.

### 3. Configure API Key
1. Open the `MainActivity.kt` file.
2. Replace the placeholder API key with your own in the following section:
   ```kotlin
   headers["X-CMC_PRO_API_KEY"] = "your_api_key_here"
   ```

### 4. Build the Project
- Click on **Build > Make Project** or use the shortcut `Ctrl + F9` to compile the project.

### 5. Run the App
1. Connect your Android device or start an emulator.
2. Click on **Run > Run 'app'** or use the shortcut `Shift + F10`.

---

## How It Works

1. **API Integration**
   - Fetches cryptocurrency data from CoinMarketCap's API.
   - Parses the JSON response and updates the app’s UI dynamically.

2. **Search Bar**
   - Filters the displayed list of cryptocurrencies as the user types in the search box.
   - Utilizes `TextWatcher` for real-time updates.

3. **RecyclerView**
   - Displays cryptocurrency data in a scrollable list.
   - Uses a custom adapter (`RvAdapter`) to bind data to views.

4. **Error Handling**
   - Displays `Toast` messages for network or API errors.

---

## Contributing
Contributions are welcome! If you have any suggestions or improvements, feel free to fork the repository and submit a pull request.

---
