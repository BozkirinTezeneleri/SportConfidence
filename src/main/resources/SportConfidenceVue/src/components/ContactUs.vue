<template>

  <div class= "container">
      <div class="row text-center" id= "heading">
        <div class= "bg-image">
          <div class= "col-lg-6 col-lg-offset-3 share-text wow animated zoomInDown" id= "heading-text">
            <h3 class= "text-center">CONTACT US</h3>
                    <p>If you want to connect with us, Please you write to us.</p>
                    <hr class= "full">
                    <br/>
          </div>
        </div>
      </div>
      <div class= "row text-center main_content">
        <div class= "col-md-6 col-md-offset-3 text-center">
          <form method="post" action="#">
            <div class= "form">
              <div class="input-group margin-bottom-sm">
                  <span class="input-group-addon">
                    <i class="fa fa-user fa-fw"></i>
                  </span>
                <input class="form-control" type="text" placeholder="Name" required>
              </div>
              <div class="input-group margin-bottom-sm">
                  <span class="input-group-addon">
                    <i class="fa fa-envelope-o fa-fw"></i>
                  </span>
                <input class="form-control" type="text" placeholder="Email address" required>
              </div>
              <div class="input-group margin-bottom-sm">
                  <span class="input-group-addon">
                    <i class="fa fa-tags fa-fw"></i>
                  </span>
                <input class="form-control" type="text" placeholder="Subject">
              </div>
            </div>
            <div class="input-group margin-bottom-sm">
                <span class="input-group-addon">
                  <i class="fa fa-comment-o fa-fw"></i>
                </span>
              <textarea class="form-control" rows="6" type= "text" placeholder="Your Message" required></textarea>
            </div>
            <input class="btn btn-primary send" type="submit" value="Send Message">
          </form>
        </div>
      </div>

    </div>

</template>

<script>
export default {

  name :'ContactUs',

}
</script>
