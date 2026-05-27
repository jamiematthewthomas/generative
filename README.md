# Generative

Generative art in Java using [Processing](https://processing.org/) and [EJML](https://ejml.org/). Each sketch produces an SVG file in the project root.

## Dependencies

- [processing-core-4](https://github.com/micycle1/processing-core-4) via JitPack
- [EJML](https://ejml.org/) for matrix operations

## Build

```
mvn compile
mvn package
```

## Running a sketch

Each sketch has its own `main()`. Run it directly from your IDE, or via Maven:

```
mvn exec:java -Dexec.mainClass=dev.jamiethomas.generative.sketches.SketchDataLines3D
```

SVG output is written to `<SketchClassName>.svg` in the project root.

## Sketches

| Sketch | Description |
|--------|-------------|
| `SketchCMYCircles` | Grid of circles in CMY colours; each colour layer is rotated slightly around the canvas centre to produce a moiré-like offset. *(Deprecated — use `SketchCMYCircles3D`)* |
| `SketchCMYCircles3D` | 3D version of the CMY circles sketch using P3D transforms instead of manual geometry. |
| `SketchDataLines3D` | Perspective line graph: multiple time-series rendered as 3D lines receding into the background, stroked in cyan, magenta and yellow for a chromatic-aberration effect. Swap in real data by overriding `getData()`. |
| `SketchDrawImageUsingStrokes` | Converts a greyscale image into a field of bezier bell-curve strokes; stroke density tracks pixel darkness. |
| `SketchMatrixFromImage` | Loads an image, converts it to a greyscale EJML matrix, and renders it pixel-by-pixel onto the canvas. |
| `SketchMatrixMultiplication` | Visualises repeated matrix self-multiplication: draws four panels showing M, M², M⁴, M⁸ as colour-scaled pixel grids. |
| `Sketch3DDrawSphere` | 3D sphere experiment. |
| `Sketch3DExperiment` | General 3D exploration sketch. |

## Architecture

### Base classes

| Class | Renderer | SVG export |
|-------|----------|------------|
| `Generative` | 2D | `beginRecord`/`endRecord`; subclasses override `drawWithSVGExport()` |
| `Generative3DNoAnimation` | P3D | `beginRaw`/`endRaw`; single frame, then stops |
| `Generative3D` | P3D | `beginRaw`/`endRaw`; continuous loop — press **`r`** to capture a frame |

### Utilities

- **`ImageUtils`** — loads images from disk; converts `BufferedImage` to EJML `SimpleMatrix` (RGB or greyscale).
- **`MatrixUtils`** — renders RGB or greyscale matrices as pixel rectangles on the canvas; helpers to rescale values into the RGB range.
- **`StrokeUtils`** — reusable drawing primitives: `upwardsBellCurve` (bezier) and `hundredsAndThousands` (random short strokes).

### Conventions

- Canvas is always 1000×1000 px.
- Matrix indexing: column = x axis, row = y axis (`matrix.get(row, col)` → `matrix.get(j, i)`).
