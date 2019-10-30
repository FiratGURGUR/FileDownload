# FileDownload
Android image download mini Glide Library version


    public void downloadImage(final ImageView imageView){
        try{
            URL url = new URL("https://cdn.armut.com/UserPics/tr:w-325,h-325/75404c28-b0ea-45e6-b6df-ab740ecba806.jpeg");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            final Bitmap myBitmap = BitmapFactory.decodeStream(input);
            int width,height;
            width = dpToPx(200);
            height = dpToPx(200);
            final Bitmap newBitmap = getResizedBitmap(myBitmap,width,height);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(newBitmap);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

Activity Usage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        final ImageDownload imageDownload = new ImageDownload();

        new Thread(new Runnable() {
            @Override
            public void run() {
                imageDownload.downloadImage(imageView);
            }
        }).start();
    }
