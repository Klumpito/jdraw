# JDraw
This is an assignment for the design pattern lecture. The goal is to have an editor that is as extensible and powerful as possible. Each assignment adds an additional design pattern to the mix.

## Assignment 2 - Observer Pattern
Last Commit: fec7d94

The Observer Pattern is implemented for the `DrawView` (observer), `DrawModel` (observable and observer) and `Figures` (observable). The `Figures` passes all change notifications to the `DrawModel`, this is why the `DrawModel` now extends the `FigureListener` interface. While the `DrawModel` in turn sends all notifications to the `DrawView`, which receives all the changes via the `DrawModelListener` attribute named `ml`.

## Assignment 3 - Figures
Last Commit: ff17b0c

After adding the new Figures `Line` and `Oval` there was a lot of copy paste code; for both the `Figure` and for the `FigureTool`. This is why all of this code got abstracted and overwritten where necessary.

## Assignment 4 - Handles
Last Commit: 5b87054

Each `Figure` now can add it's own handles. Each handle has a set direction, which can change if the figure gets mirrored.