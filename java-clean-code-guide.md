# Enterprise Java Clean Code & Naming Conventions

This guide covers industry-standard naming conventions and clean code practices for Enterprise Java development (e.g., Spring Boot, Jakarta EE).

## 1. Core Naming Conventions

### Packages
- **Rule:** All lowercase, plain ASCII, no underscores. Usually starts with the top-level domain name.
- **Format:** `com.companyname.projectname.modulename`
- **Examples:** `com.stripe.payment.api`, `org.springframework.boot.autoconfigure`

### Classes
- **Rule:** PascalCase (UpperCamelCase). Should be **nouns** or **noun phrases** describing the object's purpose.
- **Format:** `PascalCase`
- **Examples:** `CustomerAccount`, `PaymentProcessor`, `UserRepository`
- **Avoid:** Generic names like `Data`, `Info`, `Manager`, `Processor` (unless strictly descriptive).

### Interfaces
- **Rule:** PascalCase. Can be nouns (if they represent a role) or adjectives (typically ending in `-able` or `-ible` if they describe behavior).
- **Format:** `PascalCase`
- **Examples:** `Runnable`, `Serializable`, `PaymentGateway`, `CrudRepository`
- **Note:** Avoid the `I` prefix (e.g., `ICustomerService`). Just use `CustomerService`. The implementation should be `CustomerServiceImpl` or a specific name like `StripeCustomerService`.

### Methods
- **Rule:** camelCase. Should be **verbs** or **verb phrases** that clearly describe the action.
- **Format:** `camelCase`
- **Examples:** `calculateTotal()`, `findCustomerById()`, `save()`, `isActive()`
- **Boolean Methods:** Prefix with `is`, `has`, `can`, or `should` (e.g., `isActive()`, `hasChildren()`).

### Variables
- **Rule:** camelCase. Should be descriptive and intention-revealing.
- **Format:** `camelCase`
- **Examples:** `firstName`, `orderItemList`, `isActive`
- **Avoid:** Single-letter variables except for brief loops (e.g., `i`, `j`, `k`). For collections, prefer plurals (e.g., `users` instead of `userList`).

### Constants (Static Final)
- **Rule:** UPPER_SNAKE_CASE. All letters uppercase with words separated by underscores.
- **Format:** `UPPER_SNAKE_CASE`
- **Examples:** `MAX_RETRY_COUNT`, `DEFAULT_TIMEOUT_MS`, `API_BASE_URL`

### Generics
- **Rule:** Single uppercase letters.
- **Examples:**
  - `E` - Element (used extensively by the Java Collections Framework)
  - `K` - Key
  - `N` - Number
  - `T` - Type
  - `V` - Value

---

## 2. Enterprise Component Suffixes

In large-scale applications, appending the architectural layer to the class name helps developers instantly grasp the file's purpose.

| Component Type | Suffix | Example | Description |
|---|---|---|---|
| **Controller / API** | `Controller`, `Resource` | `UserController` | Handles HTTP requests and responses. |
| **Service** | `Service` | `OrderService` | Contains core business logic. |
| **Service Implementation**| `ServiceImpl` | `OrderServiceImpl` | The concrete implementation of a Service interface. |
| **Repository / DAO** | `Repository`, `Dao` | `CustomerRepository` | Handles database access and native queries. |
| **Entities** | *(None)* | `Customer`, `User` | Represents a database table. Keep them clean nouns without suffixes. |
| **Data Transfer Objects**| `Dto`, `Request`, `Response` | `UserRegistrationDto`, `LoginRequest` | Objects used to transfer data between the client and API layers. |
| **Configuration** | `Config`, `Configuration`| `SecurityConfig` | Contains application configuration (e.g., Beans, Security). |
| **Exception** | `Exception` | `UserNotFoundException` | Custom exceptions. Always extend from `RuntimeException` or `Exception`. |
| **Utilities** | `Util`, `Utils` | `DateUtils` | Classes containing only static helper methods. |
| **Filters/Interceptors** | `Filter`, `Interceptor`| `JwtAuthFilter` | Request/Response interceptors. |

---

## 3. Clean Code Principles for Naming

### 1. Intention-Revealing Names
The name of a variable, function, or class should answer to all the big questions: why it exists, what it does, and how it is used.
```java
// Bad
int d; // elapsed time in days
List<int[]> list1 = new ArrayList<>();

// Good
int elapsedTimeInDays;
List<Cell> gameBoard = new ArrayList<>();
```

### 2. Avoid Disinformation
Do not use names that leave false impressions.
- Avoid terminology like `hp`, `aix`, `sco` if they aren't directly related to the OS or concepts.
- Do not refer to a grouping of accounts as `accountList` unless it is actually a `List`. Use `accounts` or `accountGroup` instead.

### 3. Make Meaningful Distinctions
Don't use noise words. `ProductInfo` or `ProductData` are indistinct from `Product`.
```java
// Bad
public void copyChars(char a1[], char a2[]) {}
public class Customer {}
public class CustomerObject {}

// Good
public void copyCharacters(char[] source, char[] destination) {}
public class Customer {}
```

### 4. Pronounceable and Searchable Names
If you can't pronounce it, you can't discuss it without sounding silly. Searchable names make finding bugs and navigating a massive enterprise codebase easier.
```java
// Bad
private Date genymdhms;
private final int MAX_CLSS_PER_STDT = 7;

// Good
private Date generationTimestamp;
private final int MAX_CLASSES_PER_STUDENT = 7;
```

### 5. Pick One Word per Concept
Choose a single word for each abstract concept and stick with it. Don't mix `fetch`, `retrieve`, and `get` as methods for your controllers or services. If you use `get` (e.g., `getUser`), use it everywhere (`getProduct`, `getOrder`).

---

## 4. Method Naming Patterns (Enterprise Standard)

* **Finders:** `find[Noun]By[Attribute]` (e.g., `findUserByEmail(String email)`)
* **Mutators:** `update`, `save`, `create`, `delete` (e.g., `saveOrder(...)`)
* **Checks:** `existsBy`, `has` (e.g., `existsByUsername(String username)`)
* **Converters:** `to[Type]`, `from[Type]` (e.g., `toUserDto(User user)`) - useful for Mapper classes.

## 5. Summary Checklist

> [!TIP]
> - Are my classes nouns?
> - Are my methods verbs?
> - Do my variables clearly state what they hold?
> - Are boolean questions phrased correctly (`isValid`, `hasError`)?
> - Did I avoid vague words like `Data`, `Manager`, `Helper`, `Info`?
> - Does my class suffix match its architectural layer (`Service`, `Controller`, `Dto`)?
