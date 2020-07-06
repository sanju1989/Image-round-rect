public class RoundImageView extends AppCompatImageView {

    private float radius = 18.0f;
    private Path path;
    private RectF rect;

    public RoundImageView(Context context) {
        super(context);
        init();
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        path = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        path=getPath(radius,true,true,false,false);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
    private Path getPath(float radius, boolean topLeft, boolean topRight,
                         boolean bottomRight, boolean bottomLeft) {

        final Path path = new Path();
        final float[] radii = new float[8];

        if (topLeft) {
            radii[0] = radius;
            radii[1] = radius;
        }

        if (topRight) {
            radii[2] = radius;
            radii[3] = radius;
        }

        if (bottomRight) {
            radii[4] = radius;
            radii[5] = radius;
        }

        if (bottomLeft) {
            radii[6] = radius;
            radii[7] = radius;
        }

        path.addRoundRect(new RectF(0, 0, getWidth(), getHeight()),
                radii, Path.Direction.CW);

        return path;
    }
}
