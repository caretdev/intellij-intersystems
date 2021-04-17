# IntelliJ IDEA plugin for InterSystems

![Build](https://github.com/caretdev/intellij-intersystems/workflows/Build/badge.svg)
<!--
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
-->

## Features

* Syntax Highlighting for ObjectScript code based on Textmate
* [InterSystems Language-Server](https://github.com/caretdev/intersystems-ls/) support
  * Import and compile after save 

## Installation

<!--
- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "intellij-intersystems"</kbd> >
  <kbd>Install Plugin</kbd>
-->
- Manually:

  Download the [latest release](https://github.com/caretdev/intellij-intersystems/releases/) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>
  
## Configuration

* Open any project containing ObjectScript code
* Open <kbd>Settings/Preferences</kbd> > <kbd>Language & Frameworks</kbd> > <kbd>InterSystems</kbd>
* Fill all the text fields 
  ![Preferences](https://raw.githubusercontent.com/caretdev/intellij-intersystems/main/images/Preferences.png)
  
## Usage

* Open any `mac` or `cls` file, change and save
* Open <kbd>Event log</kbd>, it should show events about compilation status
  ![EventLog](https://raw.githubusercontent.com/caretdev/intellij-intersystems/main/images/EventLog.png)
  
![Screenshot](https://raw.githubusercontent.com/caretdev/intellij-intersystems/main/images/Screenshot.png)
