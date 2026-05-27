# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Generative art in Java using [Processing](https://processing.org/) (via the `processing-core-4` JitPack mirror) and [EJML](https://ejml.org/) for matrix operations. Each sketch produces an SVG output file in the project root, named after the sketch class.

## Build

```
mvn compile
mvn package
```

There are no tests. Each sketch is run directly via its own `main()` method in the IDE or via `mvn exec:java`.

## Architecture

### Base Classes

Three abstract base classes control the Processing/SVG lifecycle — sketches extend exactly one of them:

- **`Generative`** — 2D. Overrides `draw()` to wrap `beginRecord`/`endRecord` around `drawWithSVGExport()`, write the SVG, then stop. Subclasses override `drawWithSVGExport()`.
- **`Generative3DNoAnimation`** — 3D, single-frame. Same stop-after-one-frame pattern as `Generative` but uses `beginRaw`/`endRaw` (required for P3D → SVG).
- **`Generative3D`** — 3D with a live animation loop. SVG is only recorded when the user presses **`r`**; subclasses override `drawWithSVGExport()` and the loop runs continuously otherwise.

### Sketches (`sketches/`)

Each class extends one of the base classes and has its own `main()` that calls `PApplet.runSketch(...)`. To run a sketch, run its `main()`. SVG output lands at `<SketchClassName>.svg` in the project root.

### Utilities (`utils/`)

- **`ImageUtils`** — loads images from disk; converts `BufferedImage` to EJML `SimpleMatrix` (RGB packed int or greyscale 0–255).
- **`MatrixUtils`** — draws RGB or greyscale `SimpleMatrix` values onto the Processing canvas as pixel rectangles; helpers to scale matrices into the RGB range for display.
- **`StrokeUtils`** — reusable drawing primitives: `upwardsBellCurve` (bezier) and `hundredsAndThousands` (random short line strokes).

### Shapes (`shapes/`)

Plain value objects (e.g. `Circle`) used to pass geometry between sketch logic and rendering calls.

## Key Conventions

- `Generative` canvas is always 1000×1000 px.
- 3D sketches use `P3D` renderer and must use `beginRaw`/`endRaw` (not `beginRecord`/`endRecord`) for SVG export.
- Matrix column index = x axis, row index = y axis (EJML stores row-major: `matrix.get(row, col)` → `matrix.get(j, i)`).
