# Favorite Calculator

## GitHub Repo:
https://github.com/coreyan1234/cs4520-assg3-starter-code.git

## Description
This application implements a simple calculator using 2 approaches: MVP and MVVM. In both approaches, users can perform add, subtract, multiply, and divide operations.

## Project Structure
1. MVP
   - MvpContract
     - Interface that includes sub-interfaces for the model, view, and presenter
   - MvpFragment
     - The "view" - Contains operations to render information to the user
   - MvpModel
     - The "model" - Contains data manipulation/computations and business logic. Calculates the user's inputs
   - MvpPresenter
     - The "presenter" - Acts as a controller between the view and model.
3. MVVM
   - MvvmFragment
   - MvvmViewModel
     - Allows for calculator results/outputs to survive when device orientation changes
5. Activity
   - MainActivity
     - Creates and sets up the initial content view
     - XML
       - Contains instructions for the general layout as well as the navHostFragment so that it keeps track of the navigation between fragments
6. Misc
   - HomeFragment
     - Displays 2 buttons: 'MVP' and 'MVVM' for users to select which implementation of the calculator they would like to use
   - nav_graph.xml
     - Contains the navigation flow between screens/fragments
