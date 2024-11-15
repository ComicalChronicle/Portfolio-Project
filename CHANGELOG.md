# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2024.11.14

### Added

- Designed kernel implementation for HealthSystem component.

### Updated

- Added `maxHealth` and `updateMaxHealth` Kernel methods
- Removed redundant `getMaxHealth` method
- Updated abstract class with the help of new kernel methods instead of using
fields and constructors.

## 2024.10.31

### Added

- Designed abstract class for HealthSystem component.

## 2024.10.16

### Added

- Designed kernel and enhanced interfaces for HealthSystem component.

## 2024.10.03

### Added

- Designed a proof of concept for the HealthSystem component.

### Updated

- Changed design to remove the `isAlive` method in favor of using `getHealth` for more clarity.

## 2024.09.15

### Added

- Designed an InventorySystem component
- Designed a HealthSystem component
- Designed a LevelingSystem component