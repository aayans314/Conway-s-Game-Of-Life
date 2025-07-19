# Conway's Game of Life Simulator

This project implements an interactive simulation of Conway’s Game of Life using Java and the Swing library. Built as a final project for the *Data Structures and Algorithms* course, the simulator visualizes cellular automaton evolution over time. It supports user control of parameters like grid size, cell density, and number of generations, and includes tools for experimental analysis.

## Simulator Architecture

The simulation is structured around several modular components:

### **1. Core Logic (Model)**
- `Cell.java`: Represents individual cells, tracking alive/dead state and neighbors.
- `Landscape.java`: Maintains a 2D grid of `Cell` objects and applies update rules.
- `LifeSimulation.java`: Orchestrates time steps and grid updates.

### **2. Visualization and Interaction (View + Controller)**
- `LandscapeDisplay.java`: Uses Java Swing to render the grid with real-time updates.
- Button controls to start, pause, and step through generations.
- CLI arguments for custom runs: grid width, height, density, and generation count.

### **3. File I/O and Experiments**
- Supports saving simulation snapshots and exporting state data to `.txt` files.
- Batch experiments performed to study effects of grid size and initial density.

## Experiments & Observations

Systematically varied initial parameters to analyze emergent behavior over time.

### **1. Stability by Density**
Explored how initial live-cell density influences long-term population dynamics.
- Too low (<0.1): Simulation dies out quickly.
- Optimal (~0.25–0.35): Rich patterns, oscillators, and gliders emerge.
- Too high (>0.5): Overcrowding leads to rapid stagnation.

### **2. Scaling and Performance**
Tested grid sizes up to 300×300. Display frame rate maintained through conditional repaint throttling and efficient iteration.

### **3. Data Logging**
Exported step-by-step cell counts and final states to files. These outputs supported quantitative analysis (see `experiments.txt`).

## File Structure

- **Project/**
  - `Cell.java`, `Landscape.java`, `LifeSimulation.java`: Simulation logic.
  - `LandscapeDisplay.java`: GUI renderer.
  - `*.txt`: Experiment logs and snapshots.
  - `*.png`: Screenshots of emergent patterns.

- **GameOfLife_Report_AayanShah.pdf**  
  Final writeup including experimental design, data visualizations, and reflection.

## Acknowledgements

This project was made possible due to help from various online articles, YouTube videos, and inspiration from my classmate Rish.


## Author

**Aayan Shah**  
Computer Science & Physics Student  
[GitHub Profile](https://github.com/aayans314)
