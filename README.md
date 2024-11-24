
# Ticketing and Graph System

This project demonstrates a versatile ticketing system and graph traversal utilities implemented in Java. The design incorporates advanced object-oriented principles and practical software engineering techniques, making it a comprehensive solution for ticketing operations and graph-based data structures.

## Features

1. **Ticketing System**:
   - A robust ticketing platform using object-oriented principles.
   - Includes functionalities to manage users, ticket purchases, and generate detailed receipts.

2. **Graph Iterators**:
   - Implements breadth-first and depth-first traversal algorithms for graph structures.
   - Supports generic graph data structures, making it extensible to various applications.

3. **Gardening Module**:
   - Features a gratitude-inspired gardening simulation for creative exploration.

4. **Thread Safety**:
   - Demonstrates asynchronous programming concepts to ensure thread-safe operations.

## Technology Stack

- **Language**: Java
- **Testing Framework**: JUnit
- **Design Patterns**:
  - Decorator Pattern (for flexible feature enhancements).
  - Iterator Pattern (for graph traversal algorithms).
  - Object-Oriented Design Principles.

## File Structure

```
src/
├── main/
│   ├── java/
│   │   ├── gardening/           # Gratitude-related modules
│   │   ├── graph/               # Graph iterators and structures
│   │   ├── ticketingsystem/     # Ticketing system core logic
│   │   ├── unsw/                # Utility and shared modules
├── test/
│   ├── java/
│   │   ├── gardening/           # Tests for gardening modules
│   │   ├── graph/               # Tests for graph traversal and structures
│   │   ├── ticketingsystem/     # Tests for ticketing system functionality
```

## Usage

### Compilation
Compile the project using Gradle:
```bash
./gradlew build
```

### Running the System
Run individual modules via their main classes:
```bash
# Run the Ticketing System
java -cp build/classes/java/main ticketingsystem.Application

# Run the Graph Module
java -cp build/classes/java/main graph.Graph
```

### Testing
Execute the comprehensive test suite:
```bash
./gradlew test
```

## Example Outputs

1. **Ticketing System**:
   - Users can purchase tickets, and the system generates detailed, user-friendly receipts.

2. **Graph Iterators**:
   - Graphs can be traversed using breadth-first or depth-first strategies.

## Future Enhancements

1. **Expand Ticketing Features**:
   - Introduce payment gateway integration.
   - Support multiple ticket types and bulk purchases.

2. **Graph Enhancements**:
   - Add weighted graph support and implement shortest-path algorithms.

3. **User Interface**:
   - Build a graphical or web-based UI for a more interactive user experience.

## Acknowledgments

This project showcases advanced programming skills and is designed for real-world adaptability.
