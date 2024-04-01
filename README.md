# Connection Pool Implementation Comparison

This project demonstrates the implementation and performance comparison of a custom connection pool (`BasicConnectionPool`) with built-in connection pool libraries like c3p0, HikariCP, and Apache Commons DBCP 2.

## Overview

The project consists of the following components:

1. **Interface**: `ConnectionPool`
   - Defines the basic operations and properties of a connection pool such as `max_pool_size`, `getConnection`, `releaseConnection`, and `shutdown`.

2. **Implementation**: `BasicConnectionPool`
   - Implements the `ConnectionPool` interface.
   - Utilizes a list of connections created on startup to provide a fixed pool of connections.
   
3. **Threads**: 
   - A set of threads performing parallel tasks.
   - Each thread performs a `pg_sleep(5)` operation using PostgreSQL JDBC.

## Usage

1. **BasicConnectionPool**:
   - The `BasicConnectionPool` class provides a straightforward implementation of a connection pool with a fixed number of connections.
   - Time taken: ~5s with 15 parallel threads.

2. **c3p0**:
   - Configuration and usage of c3p0 connection pool library.
   - Time taken: ~2s with c3p0 connection pool.

3. **HikariCP**:
   - Configuration and usage of HikariCP connection pool library.
   - Time taken: ~4s with HikariCP connection pool.

4. **Apache Commons DBCP 2**:
   - Configuration and usage of Apache Commons DBCP 2 connection pool library.
   - Time taken: ~4s with Apache Commons DBCP 2 connection pool.

## How to Run

1. Clone this repository.
2. Navigate to the directory containing the project.
3. Compile and run the project.
4. Observe the performance differences among the different connection pool implementations.

## Dependencies

- PostgreSQL JDBC driver (included in the project).
- Libraries for connection pool implementations:
  - c3p0
  - HikariCP
  - Apache Commons DBCP 2

## Contributions

Contributions are welcome! If you find any issues or have suggestions for improvement, feel free to open an issue or create a pull request.
