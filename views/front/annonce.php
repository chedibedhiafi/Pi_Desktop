<?PHP
include_once '../../contoller/AnnonceC.php';
include_once $_SERVER['DOCUMENT_ROOT'] . '/integrationartisto/ElArtisto-main/model/Annonce.php';
require_once("../front/includes/header.php");
//$annonce = $annoncec->afficherAnnonce();


$annoncec = new AnnonceC();

if (isset($_GET['id'])) {
    //$albumC->deleteAlbum($_GET['idAlbum']);
    $annonce = $annoncec->afficherAnnonce($_GET['id']);
} else
    header('Location:annonces.php');


$error = "";
$categorie = "";
$img = "";

if (
    isset($_POST["nom"]) &&
    isset($_POST["prix"]) &&
    isset($_POST["descr"])
) {
    if (
        !empty($_POST["nom"]) &&
        !empty($_POST["prix"]) &&
        !empty($_POST["descr"])
    ) {
        $annonce = new Annonce(
            $categorie,
            $_POST['nom'],
            $_POST['prix'],
            $_POST['descr'],
            $img,
            $_SESSION['user_id']
        );

        $annoncec->modifierAnnonce($annonce, $_GET['id']);
        header('Location:annonces.php');
    } else
        $error = "Missing information";
}

if (isset($_POST['supprimer'])) {
    $annoncec->supprimerAnnonce($_GET['id']);
    header('Location:annonces.php');
}

?>

<?PHP  ?>

<!-- end page-transition -->
<link rel='stylesheet' id='wp-block-library-css' href='../../assets/css/style.mine23c.css?ver=5.7' media='all' />
<link rel='stylesheet' id='contact-form-7-css' href='../../assets/css/styles91d5.css?ver=5.4' media='all' />
<link rel='stylesheet' id='cinzel-google-fonts-css' href='https://fonts.googleapis.com/css?family=Cinzel%3A400%2C600&amp;ver=5.7' media='all' />
<link rel='stylesheet' id='dm-sans-google-fonts-css' href='https://fonts.googleapis.com/css?family=DM+Sans%3A400%2C500%2C700&amp;ver=5.7' media='all' />
<link rel='stylesheet' id='fontawesome-css' href='../../assets/css/fontawesome.mine23c.css?ver=5.7' media='all' />
<link rel='stylesheet' id='fancybox-css' href='../../assets/css/fancybox.mine23c.css?ver=5.7' media='all' />
<link rel='stylesheet' id='odometer-css' href='../../assets/css/odometer.mine23c.css?ver=5.7' media='all' />
<link rel='stylesheet' id='swiper-css' href='../../assets/css/swiper.mine23c.css?ver=5.7' media='all' />
<link rel='stylesheet' id='bootstrap-css' href='../../assets/css/bootstrap.mine23c.css?ver=5.7' media='all' />
<link rel='stylesheet' id='wandau-main-style-css' href='../../assets/css/stylee23c.css?ver=5.7' media='all' />
<link rel='stylesheet' id='wandau-stylesheet-css' href='../../assets/css/stylee23c.css?ver=5.7' media='all' />
<link rel='stylesheet' id='wandau-text-css' href='../../assets/css/text.css?ver=5.7' media='all' />
<link rel='stylesheet' id='elementor-icons-css' href='../../assets/css/elementor-icons.min21f9.css?ver=5.11.0' media='all' />
<link rel='stylesheet' id='elementor-animations-css' href='../../assets/css/animations.minaeb9.css?ver=3.1.4' media='all' />
<link rel='stylesheet' id='elementor-frontend-css' href='../../assets/css/frontend.minaeb9.css?ver=3.1.4' media='all' />
<link rel='stylesheet' id='elementor-post-11-css' href='../../assets/css/post-116667.css?ver=1615475306' media='all' />
<link rel='stylesheet' id='elementor-global-css' href='../../assets/css/global4183.css?ver=1615475307' media='all' />
<link rel='stylesheet' id='elementor-post-18-css' href='../../assets/css/post-1860e1.css?ver=1615486860' media='all' />
<link rel='stylesheet' id='google-fonts-1-css' href='https://fonts.googleapis.com/css?family=Roboto%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic%7CRoboto+Slab%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic&amp;ver=5.7' media='all' />
<div class="smooth-scroll">
    <div class="section-wrapper" data-scroll-section>
        <div class="search-box">
            <div class="container">
                <div class="form">
                    <h3>SEARCH BLOG</h3>
                    <form action="">
                        <input type="search" placeholder="What are you looking for ?" value="" name="s" id="s">
                        <input type="submit" value="SEARCH">
                    </form>
                </div>
                <!-- end form -->
            </div>
        </div>
        <!-- end search-box -->
        <aside class="side-widget">
            <svg viewBox="0 0 600 1080" preserveAspectRatio="none" version="1.1">
                <path d="M540,1080H0V0h540c0,179.85,0,359.7,0,539.54C540,719.7,540,899.85,540,1080z"></path>
            </svg>
            <figure class="logo"><img src="../../assets/img/logo-light.png" alt="L'artisto"></figure>
            <!-- end logo -->
            <div class="inner">
                <div class="widget_text widget aside">
                    <div class="textwidget custom-html-widget">
                        <figure><img src="../../assets/img/us.png" alt="Image"></figure>
                        <p>This project was developed by <strong>EXCELL TEAM</strong> as their second year web project
                            the theme is <u>Art &amp; Culture</u>. Briefly the project will be EPIC !</p>
                    </div>
                </div>
                <div class="widget_text widget aside">
                    <h6 class="widget-title">The Team</h6>
                    <div class="textwidget custom-html-widget">
                        <p>Rayen BOURGUIBA<br>Walid MAALEJ<br>Yasmine BEN
                            ABDA<br>Cyrine ESSID<br>
                            Riham MATOUSSI</p>
                    </div>
                </div>
            </div>
            <!-- end inner -->
            <div class="display-mobile">
                <div class="custom-menu">
                    <ul>
                        <li><a href="#">Eng</a></li>
                    </ul>
                </div>
                <!-- end custom-menu -->
                <div class="site-menu">
                    <ul id="menu-main-menu" class="menu">
                        <li itemscope="itemscope" itemtype="" id="menu-item-460" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-460 nav-item"><a title="Visit" href="visit.html" class="nav-link" data-text="Visit">Visit</a><i></i>
                        </li>
                        <li itemscope="itemscope" itemtype="" id="menu-item-459" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-459 nav-item"><a title="Exhibitions" href="exhibitions.php" class="nav-link" data-text="Exhibitions">Exhibitions</a><i></i></li>
                        <li itemscope="itemscope" itemtype="" id="menu-item-458" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-458 nav-item"><a title="Collections" href="annonces.php" class="nav-link" data-text="Collections">Annonces</a><i></i></li>
                        <li itemscope="itemscope" itemtype="" id="menu-item-457" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-457 nav-item"><a title="About" href="blog.php" class="nav-link" data-text="About">Blog</a><i></i>
                        </li>
                        <li itemscope="itemscope" itemtype="" id="menu-item-456" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-456 nav-item"><a title="Contact" href="contact.html" class="nav-link" data-text="Contact">Contact</a><i></i>
                        </li>
                    </ul>
                </div>
                <!-- end site-menu -->
            </div>
            <!-- end display-mobile -->
        </aside>
        <!-- end side-widget -->

        <nav class="navbar">
            <div class="logo"><a href="./index.php"> <img src="../../assets/img/logo.png" alt="L'Artisto"></a></div>
            <div class="custom-menu">

            </div>
            <div class="site-menu">
                <ul id="menu-main-menu-1" class="nav-menu">
                    <li itemscope="itemscope" itemtype="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-460 nav-item"><a title="Visit" href="./visit.html" class="nav-link" data-text="Visit">Visit</a><i></i>
                    </li>
                    <li itemscope="itemscope" itemtype="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-459 nav-item"><a title="Exhibitions" href="exhibitions.php" class="nav-link" data-text="Exhibitions">Exhibitions</a><i></i>
                    </li>
                    <li itemscope="itemscope" itemtype="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-458 nav-item"><a title="Collections" href="./annonces.php" class="nav-link" data-text="Collections">Annonces</a><i></i>
                    </li>
                    <li itemscope="itemscope" itemtype="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-457 nav-item"><a title="About" href="blog.php" class="nav-link" data-text="About">Blog</a><i></i>
                    </li>
                    <?php if(isset($_SESSION['user_id'])){ ?>
                    <li itemscope="itemscope" itemtype="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-456 nav-item"><a title="Contact" href="profileAnnonces.php" class="nav-link" data-text="Contact">Profile</a><i></i></li>
                    <?php } ?>
                </ul>
            </div>
            <div class="search-button"><i class="fas fa-search"></i></div>
            <!-- end search-button -->


            <div class="hamburger-menu">
                <svg class="hamburger" width="30" height="30" viewBox="0 0 30 30">
                    <path class="line line-top" d="M0,9h30" />
                    <path class="line line-center" d="M0,15h30" />
                    <path class="line line-bottom" d="M0,21h30" />
                </svg>
            </div>
            <!-- end hamburger-menu -->
            <!--            <div class="navbar-button"><a href="./visit.html">SIGN IN</a></div>-->
            <!--            <div class="navbar-button"><a href="./visit.html">SIGN UP</a></div>-->
            <?php if(isset($_SESSION['user_id'])){
            if($_SESSION['user_id'] == $annonce['host']) { ?>
            <div class="navbar-button"> <a href="form_boost.php?id=<?PHP echo $_GET['id'];?>">BOOSTER MON ANNONCE</a> </div>
            <?php }} ?>
            <?php
            $curr_page = basename(__FILE__);
            require_once("./includes/registration.php");
            if(!isset($_SESSION['user_id']))
            header('Location:annonces.php');
            ?>

            <!-- end navbar-button -->
        </nav>
        <header class="page-header" style="background: url(../../assets/img/page-header.jpg) center #ffffff;">
            <div class="inner">
                <svg width="580" height="400" class="svg-morph">
                    <path id="svg_morph" d="m261,30.4375c0,0 114,6 151,75c37,69 37,174 6,206.5625c-31,32.5625 -138,11.4375 -196,-19.5625c-58,-31 -86,-62 -90,-134.4375c12,-136.5625 92,-126.5625 129,-127.5625z" />
                </svg>
                <h1>Annonces</h1>
                <p>Vous pouvez créer votre propre annonce, la booster ou encore remplir votre panier pour passer vos commandes
                </p>
            </div>
            <!-- end inner -->
        </header>
        <!-- end navbar -->


        <div data-elementor-type="wp-post" data-elementor-id="696" class="elementor elementor-696" data-elementor-settings="[]">
            <div class="elementor-section-wrap">
                <section class="elementor-section elementor-top-section elementor-element elementor-element-786277d elementor-section-boxed elementor-section-height-default elementor-section-height-default" data-id="786277d" data-element_type="section" data-settings="{&quot;background_background&quot;:&quot;classic&quot;}">
                    <div class="elementor-container elementor-column-gap-default">
                        <div class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-f8e0d4f" data-id="f8e0d4f" data-element_type="column">
                            <div class="elementor-widget-wrap elementor-element-populated">
                                <div class="elementor-element elementor-element-c5b2988 elementor-widget elementor-widget-text-box" data-id="c5b2988" data-element_type="widget" data-widget_type="text-box.default">
                                    <div class="elementor-widget-container">
                                        <div class="text-box" data-scroll data-scroll-speed="0">
                                            <h2><?PHP echo $annonce['nom']; ?> </h2>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section class="elementor-section elementor-top-section elementor-element elementor-element-e9b4bc5 elementor-section-boxed elementor-section-height-default elementor-section-height-default" data-id="e9b4bc5" data-element_type="section">
                    <div class="elementor-container elementor-column-gap-default">
                        <div class="elementor-column elementor-col-33 elementor-top-column elementor-element elementor-element-cc1d464" data-id="cc1d464" data-element_type="column">
                            <div class="elementor-widget-wrap elementor-element-populated">
                                <div class="elementor-element elementor-element-d78475e elementor-widget elementor-widget-image-content-box" data-id="d78475e" data-element_type="widget" data-widget_type="image-content-box.default">
                                    <div class="elementor-widget-container">
                                        <div class="image-content-box" data-scroll data-scroll-speed="-1">
                                            <figure> <img src="<?PHP echo $annonce['img']; ?>" alt="<?PHP echo $annonce['nom']; ?>"> </figure>
                                            <div class="content-box">
                                                <h3><?PHP echo $annonce['prix']; ?> TND</h3>
                                                <p><strong><?PHP echo $annonce['descr']; ?></strong></p>
                                                <p></p>
                                                <?php if(isset($_SESSION['user_id'])){ 
                                                if($_SESSION['user_id'] == $annonce['host'] ) { ?>
                                                <form action="" method="POST">
                                                    <input type="submit" class="search-submit" value="Supprimer" name="supprimer" id="supprimer" />
                                                </form>
                                                <?php }
                                                else {?>
                                                <form action="ajouterCommande.php?id=<?php echo $_GET['id'];?>" method="POST">
                                                    <input type="submit" class="search-submit" value="Ajouter au panier" name="Ajouter au panier" id="Ajouter au panier" />
                                                </form>

                                                <?php }} ?>
                                                <div class="pagination-bar">
                                                </div>
                                                
                                            </div>
                                            <!-- end content-box -->

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                </section>

                <?php if(isset($_SESSION['user_id'])){ 
                if($_SESSION['user_id'] == $annonce['host']) { ?>
                <section class="content-section">
                    <div class="col-lg-4">
                        <aside class="sidebar widget-area">
                            <div id="search-2" class="widget widget_search">
                                <h6 class="widget-title">Modifier votre annonce</h6>
                                <form method="POST" class="search-form" action="">
                                    <label>
                                        <input type="search" class="search-field" placeholder="Nom de l'article" value="" name="nom" />
                                    </label>
                                    <label>
                                        <input type="search" class="search-field" placeholder="Prix" value="" name="prix" />
                                    </label>
                                    <label>
                                        <textarea rows="4" cols="50" name="descr" class="descr" placeholder="Description"></textarea>
                                    </label>
                                    </label>
                                    <input type="submit" class="search-submit" value="Modifier" name="modifier" id="modifier" />
                                    <div class="pagination-bar">
                                    </div>
                            </div>
                    </div>
                </section>
                <?php }} ?>


                <section class="content-section no-spacing" data-background="#F1EDD5">
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <div class="newsletter-box">
                                    <div class="form">
                                        <div class="titles">
                                            <h6>Subscribe Newsletter</h6>
                                            <h2>Sign up to get the latest news</h2>
                                        </div>
                                        <!-- end titles -->
                                        <script>
                                            (function() {
                                                window.mc4wp = window.mc4wp || {
                                                    listeners: [],
                                                    forms: {
                                                        on: function(evt, cb) {
                                                            window.mc4wp.listeners.push({
                                                                event: evt,
                                                                callback: cb
                                                            });
                                                        }
                                                    }
                                                }
                                            })();
                                        </script>
                                        <!-- Mailchimp for WordPress v4.8.3 - https://wordpress.org/plugins/mailchimp-for-wp/ -->
                                        <form id="mc4wp-form-1" class="mc4wp-form mc4wp-form-468" method="post" data-id="468" data-name="">
                                            <div class="mc4wp-form-fields">
                                                <div class="inner">
                                                    <input type="email" placeholder="Enter your e-mail address">
                                                    <input type="submit" value="SIGN UP">
                                                </div>
                                                <small>Will be used in accordance with our
                                                    <a href="../privacy-policy/index.html">Privacy Policy</a></small>
                                            </div><label style="display: none !important;">Leave this field empty if you're human: <input type="text" name="_mc4wp_honeypot" value="" tabindex="-1" autocomplete="off" /></label><input type="hidden" name="_mc4wp_timestamp" value="1617619617" /><input type="hidden" name="_mc4wp_form_id" value="468" /><input type="hidden" name="_mc4wp_form_element_id" value="mc4wp-form-1" />
                                            <div class="mc4wp-response"></div>
                                        </form>
                                        <!-- / Mailchimp for WordPress Plugin -->
                                    </div>
                                    <!-- end form -->
                                    <figure class="newsletter-image" data-scroll data-scroll-speed="0.7"><img src="../../assets/img/newsletter-image.png" alt="Sign up to get the latest news"></figure>
                                </div>
                                <!-- end newsletter-box -->
                            </div>
                            <!-- end col-12 -->
                        </div>
                        <!-- end row -->
                    </div>
                    <!-- end container -->
                </section>
                <!-- end content-section -->
                <footer class="footer" style="  ">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-6">
                                <div class="widget_text widget footer-widget">
                                    <h6 class="widget-title">About Museum</h6>
                                    <div class="textwidget custom-html-widget">
                                        <ul class="footer-menu">
                                            <li><a href="#">About us </a></li>
                                            <li><a href="#">Contact us</a></li>
                                            <li><a href="#">National work</a></li>
                                            <li><a href="#">International work</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="widget_text widget footer-widget">
                                    <h6 class="widget-title">Connect Us</h6>
                                    <div class="textwidget custom-html-widget">
                                        <ul class="social-media">
                                            <li><a href="#"><i class="fab fa-facebook-f"></i> /wandau-uk</a></li>
                                            <li><a href="#"><i class="fab fa-twitter"></i> /wandau-museum</a></li>
                                            <li><a href="#"><i class="fab fa-youtube"></i> /wandau-tv</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="widget_text widget footer-widget">
                                    <h6 class="widget-title">Visit Us Now</h6>
                                    <div class="textwidget custom-html-widget">
                                        <address class="address">
                                            Cromwell Road New Town SW7 <strong>London - England</strong> <i class="fas fa-info-circle"></i> +44 (0)20 7942 2000
                                        </address>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->
                    </div>
                    <!-- end container -->
                    <div class="footer-bottom">
                        <div class="container"> <span class="copyright">&copy; 2021 Wandau | Art &amp; History Museum</span> <span class="creation">Site created by <a href="https://themezinho.net/">themezinho</a></span> </div>
                        <!-- end container -->
                    </div>
                    <!-- end footer-bottom -->
                </footer>
                <!-- end footer -->
            </div>
        </div>
        <script>
            (function() {
                function maybePrefixUrlField() {
                    if (this.value.trim() !== '' && this.value.indexOf('http') !== 0) {
                        this.value = "http://" + this.value;
                    }
                }

                var urlFields = document.querySelectorAll('.mc4wp-form input[type="url"]');
                if (urlFields) {
                    for (var j = 0; j < urlFields.length; j++) {
                        urlFields[j].addEventListener('blur', maybePrefixUrlField);
                    }
                }
            })();
        </script>
        <script src='../../assets/js/wp-polyfill.min89b1.js?ver=7.4.4' id='wp-polyfill-js'></script>
        <script id='wp-polyfill-js-after'>
            ('fetch' in window) || document.write('<script src="../../assets/js/wp-polyfill-fetch.min6e0e.js?ver=3.0.0"></scr' + 'ipt>');
            (document.contains) || document.write('<script src="../../assets/js/wp-polyfill-node-contains.min2e00.js?ver=3.42.0"></scr' + 'ipt>');
            (window.DOMRect) || document.write('<script src="../../assets/js/wp-polyfill-dom-rect.min2e00.js?ver=3.42.0"></scr' + 'ipt>');
            (window.URL && window.URL.prototype && window.URLSearchParams) || document.write('<script src="../../assets/js/wp-polyfill-url.min5aed.js?ver=3.6.4"></scr' + 'ipt>');
            (window.FormData && window.FormData.prototype.keys) || document.write('<script src="../../assets/js/wp-polyfill-formdata.mine9bd.js?ver=3.0.12"></scr' + 'ipt>');
            (Element.prototype.matches && Element.prototype.closest) || document.write('<script src="../../assets/js/wp-polyfill-element-closest.min4c56.js?ver=2.0.2"></scr' + 'ipt>');
            ('objectFit' in document.documentElement.style) || document.write('<script src="../../assets/js/wp-polyfill-object-fit.min531b.js?ver=2.3.4"></scr' + 'ipt>');
        </script>
        <script src='../../assets/js/hooks.minf521.js?ver=50e23bed88bcb9e6e14023e9961698c1' id='wp-hooks-js'></script>
        <script src='../../assets/js/i18n.min87d6.js?ver=db9a9a37da262883343e941c3731bc67' id='wp-i18n-js'></script>
        <script id='wp-i18n-js-after'>
            wp.i18n.setLocaleData({
                'text direction\u0004ltr': ['ltr']
            });
        </script>
        <script src='../../assets/js/lodash.minf492.js?ver=4.17.19' id='lodash-js'></script>
        <script id='lodash-js-after'>
            window.lodash = _.noConflict();
        </script>
        <script src='../../assets/js/url.minacd8.js?ver=0ac7e0472c46121366e7ce07244be1ac' id='wp-url-js'></script>
        <script id='wp-api-fetch-js-translations'>
            (function(domain, translations) {
                var localeData = translations.locale_data[domain] || translations.locale_data.messages;
                localeData[""].domain = domain;
                wp.i18n.setLocaleData(localeData, domain);
            })("default", {
                "locale_data": {
                    "messages": {
                        "": {}
                    }
                }
            });
        </script>
        <script src='../../assets/js/api-fetch.minf3b9.js?ver=a783d1f442d2abefc7d6dbd156a44561' id='wp-api-fetch-js'></script>
        <script id='wp-api-fetch-js-after'>
            wp.apiFetch.use(wp.apiFetch.createRootURLMiddleware("../wp-json/index.html"));
            wp.apiFetch.nonceMiddleware = wp.apiFetch.createNonceMiddleware("37d14959a5");
            wp.apiFetch.use(wp.apiFetch.nonceMiddleware);
            wp.apiFetch.use(wp.apiFetch.mediaUploadMiddleware);
            wp.apiFetch.nonceEndpoint = "../wp-admin/admin-ajaxf809.html?action=rest-nonce";
        </script>
        <script id='contact-form-7-js-extra'>
            var wpcf7 = [];
        </script>
        <script src='../../assets/js/index91d5.js?ver=5.4' id='contact-form-7-js'></script>
        <script src='../../assets/js/bootstrap.mine23c.js?ver=5.7' id='bootstrap-js'></script>
        <script src='../../assets/js/gsap.mine23c.js?ver=5.7' id='gsap-js'></script>
        <script src='../../assets/js/locomotive-scroll.mine23c.js?ver=5.7' id='locomotive-scroll-js'></script>
        <script src='../../assets/js/ScrollTrigger.mine23c.js?ver=5.7' id='scroll-trigger-js'></script>
        <script src='../../assets/js/kinetic-slidere23c.js?ver=5.7' id='kinetic-slider-js'></script>
        <script src='../../assets/js/fancybox.mine23c.js?ver=5.7' id='fancybox-js'></script>
        <script src='../../assets/js/odometer.mine23c.js?ver=5.7' id='odometer-js'></script>
        <script src='../../assets/js/swiper.min48f5.js?ver=5.3.6' id='swiper-js'></script>
        <script id='wandau-scripts-js-extra'>
            var data = {
                "enable_preloader": "1",
                "enable_smooth_scroll": "1"
            };
        </script>
        <script src='../../assets/js/scriptse23c.js?ver=5.7' id='wandau-scripts-js'></script>
        <script src='../../assets/js/wp-embed.mine23c.js?ver=5.7' id='wp-embed-js'></script>
        <script src='../../assets/js/forms.min7bcd.js?ver=4.8.3' id='mc4wp-forms-api-js'></script>
        </body>

        </html>