# Test Automation Framework

This is a **Maven-based Test Automation Framework** for UI and API testing using:
- **Java**, **JUnit 4**, **Cucumber**
- **Selenium WebDriver** for UI tests
- **RestAssured** for API tests
- **Docker & Docker Compose** for test execution
- **Screenshot capturing** on UI test failures

—

## 🚀 **Getting Started**

### **1. Prerequisites**
Ensure you have the following installed:
- **Java 17+**
- **Maven**
- **Docker & Docker Compose**
- **Google Chrome installed and chrome driver in path**


### **2. Clone the Repository**
```bash
git clone git@github.com:gkiszczak/home-task.git
cd home-task
```

—

## 🛠 **Framework Structure**

```
├── src/test/java
│   ├── api/*              # API helpers, step definitions, model
│   ├── ui/*               # UI helpers, page object, utils, hooks, step definitions
│   ├── config             # Config classes
│
├── src/test/resources
│   ├── *.feature.         # Cucumber feature files
│
├── Dockerfile             # Dockerfilr for test execution
├── docker-compose.yml     # Docker setup for test execution
├── pom.xml                # Maven dependencies & plugins
├── README.md              # Documentation
```

—

## 🔧 **How to Run Tests**

### **1. Run API Tests Locally**
```bash
mvn clean test -Dtest=pl.inpost.home.task.runners.ApiTestRunner -Dapi.key=<your API key> -ntp```

### **2. Run UI Tests Locally**
```bash
mvn clean test  --Dtest=pl.inpost.home.task.runners.UiTestRunner -ntp```

### **3. Run Tests in Docker**
```bash
docker-compose up —build
```

Docker Compose will:
- Start a **Selenium Chrome container**
- Execute the **API/UI tests** inside a test container

To specify an **API key** from Docker Compose, edit `docker-compose.yml`:
```yaml
    environment:
      - API_KEY=your_api_key_here
```

—

## 📸 **Capturing Screenshots on UI Test Failures**
- Screenshots are saved inside `target/reports/screenshots/`.

—

## 📝 **Customization**
- Modify **`ui/utils/WebDriverProvider.java`** for UI test setup.
- Update **API base URLs** in `ApiTest.java`.
- Add **new Cucumber feature files** in `src/test/resources/features`.

—

## 🎯 **Supported Features**
✔ Run **UI & API tests**
✔ Dockerized execution
✔ Parameterized **API Key**, **UI Url**, **API Url**
✔ **Screenshots** on test failures

—

## 🛑 **Stopping the Docker Containers**
To stop the running Docker containers:
```bash
docker-compose down
```

—

