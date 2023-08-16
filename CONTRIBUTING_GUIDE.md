# Feature Branch Contributing Guide

Thank you for your interest in contributing to the Kotlin Multiplatform Food Samples repository! Your contributions will help improve the quality and diversity of the sample projects. To ensure a smooth collaboration process, we've put together this guide for contributing via feature branches.

## Table of Contents

- [Introduction](#introduction)
- [Contributing via Feature Branches](#contributing-via-feature-branches)
- [Creating a Feature Branch](#creating-a-feature-branch)
- [Making Changes](#making-changes)
- [Commit Guidelines](#commit-guidelines)
- [Pull Request](#pull-request)
- [Code Review](#code-review)
- [Merging](#merging)
- [Updating Your Branch](#updating-your-branch)
- [Closing the Issue](#closing-the-issue)
- [Feedback and Help](#feedback-and-help)

## Introduction

This guide outlines the process of contributing to the Kotlin Multiplatform Food Samples repository through feature branches. Feature branches allow contributors to work on specific changes or enhancements independently, making it easier to manage multiple contributions simultaneously.

## Contributing via Feature Branches

1. **Fork the Repository:** If you haven't already, fork the [Kotlin Multiplatform Samples repository](https://github.com/rutubishi/kotlin-multiplatform-samples/tree/main) to your GitHub account.

2. **Clone Your Fork:** Clone the forked repository to your local machine using `git clone`.

3. **Create a Feature Branch:** Before making any changes, create a new feature branch with a descriptive name that indicates the purpose of your contribution.

4. **Make Changes:** Make the necessary changes to the code, documentation, or other project files.

5. **Commit Changes:** Commit your changes to the feature branch. Please follow the commit guidelines outlined below.

6. **Push Changes:** Push your feature branch to your forked repository on GitHub.

7. **Open a Pull Request:** Open a pull request from your feature branch to the main repository's `main` branch.

8. **Code Review:** Participate in the code review process, address any feedback, and make improvements as needed.

9. **Merge and Close:** Once your pull request is approved and passes all checks, it will be merged into the `main` branch.

## Creating a Feature Branch

Create a new feature branch from the `main` branch to encapsulate your changes. Choose a descriptive and concise name for your branch that reflects the purpose of your contribution. Use dashes to separate words (e.g., `feature/add-search-functionality`).

```bash
# Create a new branch and switch to it
git checkout -b feature/add-search-functionality
```

## Making Changes

Make your desired changes to the project. Ensure that your changes align with the goals of the repository and the specific project you're contributing to.

## Commit Guidelines

Follow these guidelines when creating commit messages:

- Use a concise and descriptive title (first line) that summarizes your changes.
- If necessary, provide more details in the commit description (optional).
- Begin the title with a verb in the imperative tense (e.g., "Add," "Fix," "Update").
- Separate the title and description with a blank line.

Example:

```
Add food search functionality

Implemented a search feature that allows users to search for food products by name.
```

## Pull Request

When opening a pull request:

- Provide a clear title for your pull request.
- Include a detailed description of your changes.
- Reference any relevant issues or discussions.

## Code Review

Be prepared to participate in the code review process:

- Address any feedback or suggestions provided by reviewers.
- Make necessary changes to your code or documentation.

## Merging

Once your pull request is approved and all discussions are resolved, a repository maintainer will merge your changes into the `main` branch.

## Updating Your Branch

If changes are made to the `main` branch while you are working on a feature branch, update your branch before creating a pull request:

```bash
# Switch to the main branch
git checkout main

# Pull the latest changes
git pull origin main

# Switch back to your feature branch
git checkout feature/add-search-functionality

# Merge changes from the main branch
git merge main
```

## Closing the Issue

If your contribution is related to an open issue, please reference the issue number in your pull request description or commit message. This helps track and close the issue automatically once the pull request is merged.

For example: "Closes #123" or "Fixes #456".

## Feedback and Help

If you have questions, need assistance, or encounter any issues, feel free to reach out in the comments section of your pull request or by opening an issue. Your feedback is valuable and helps maintain a collaborative environment.

Thank you for contributing to the Kotlin Multiplatform Food Samples repository! Your efforts are greatly appreciated.