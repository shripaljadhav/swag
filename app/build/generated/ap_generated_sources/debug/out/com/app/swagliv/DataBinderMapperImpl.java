package com.app.swagliv;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.databinding.ActivityAddPhoneBindingImpl;
import com.app.swagliv.databinding.ActivityAddProductBindingImpl;
import com.app.swagliv.databinding.ActivityAddProductImagesBindingImpl;
import com.app.swagliv.databinding.ActivityChangePasswordBindingImpl;
import com.app.swagliv.databinding.ActivityCreateAddressBindingImpl;
import com.app.swagliv.databinding.ActivityDashboadBindingImpl;
import com.app.swagliv.databinding.ActivityDeliveryAddressBindingImpl;
import com.app.swagliv.databinding.ActivityEditAddressBindingImpl;
import com.app.swagliv.databinding.ActivityEditInformationBindingImpl;
import com.app.swagliv.databinding.ActivityEditProfileBindingImpl;
import com.app.swagliv.databinding.ActivityEmailSigninBindingImpl;
import com.app.swagliv.databinding.ActivityForgotPasswordBindingImpl;
import com.app.swagliv.databinding.ActivityHelpAndFaqBindingImpl;
import com.app.swagliv.databinding.ActivityImagePreviewScreenBindingImpl;
import com.app.swagliv.databinding.ActivityIntroBindingImpl;
import com.app.swagliv.databinding.ActivityLocationGpsallowPermissionBindingImpl;
import com.app.swagliv.databinding.ActivityLoginBindingImpl;
import com.app.swagliv.databinding.ActivityManageConnectionBindingImpl;
import com.app.swagliv.databinding.ActivityMatchBindingImpl;
import com.app.swagliv.databinding.ActivityMyOrderBindingImpl;
import com.app.swagliv.databinding.ActivityMyOrderDetailBindingImpl;
import com.app.swagliv.databinding.ActivityOtpBindingImpl;
import com.app.swagliv.databinding.ActivityPassionSelectionBindingImpl;
import com.app.swagliv.databinding.ActivityPhoneBindingImpl;
import com.app.swagliv.databinding.ActivityPortfolioBindingImpl;
import com.app.swagliv.databinding.ActivityProductListingBindingImpl;
import com.app.swagliv.databinding.ActivityPurchaseHistoryBindingImpl;
import com.app.swagliv.databinding.ActivityResetPasswordBindingImpl;
import com.app.swagliv.databinding.ActivitySearchCrushBindingImpl;
import com.app.swagliv.databinding.ActivitySearchScreenBindingImpl;
import com.app.swagliv.databinding.ActivityShopBindingImpl;
import com.app.swagliv.databinding.ActivityShoppingCartBindingImpl;
import com.app.swagliv.databinding.ActivityShoppingForLoveBindingImpl;
import com.app.swagliv.databinding.ActivitySideBarScreenBindingImpl;
import com.app.swagliv.databinding.ActivitySignupBindingImpl;
import com.app.swagliv.databinding.ActivitySplashBindingImpl;
import com.app.swagliv.databinding.ActivityStoreBindingImpl;
import com.app.swagliv.databinding.ActivityStoreProductDetailBindingImpl;
import com.app.swagliv.databinding.ActivitySubscriptionBindingImpl;
import com.app.swagliv.databinding.ActivityTopSheetAvtivityBindingImpl;
import com.app.swagliv.databinding.ActivityUserProfileBindingImpl;
import com.app.swagliv.databinding.ActivityVerifyOtpBindingImpl;
import com.app.swagliv.databinding.ActivityWalletBindingImpl;
import com.app.swagliv.databinding.AdapterAddressBindingImpl;
import com.app.swagliv.databinding.AppComplaintBindingImpl;
import com.app.swagliv.databinding.AppFeedbackBindingImpl;
import com.app.swagliv.databinding.BottomsheetFilterBindingImpl;
import com.app.swagliv.databinding.BottomsheetShoppingCartBindingImpl;
import com.app.swagliv.databinding.BottomsheetSomeoneElseShoppingBindingImpl;
import com.app.swagliv.databinding.CommonHeaderBindingImpl;
import com.app.swagliv.databinding.CommonHeaderV2BindingImpl;
import com.app.swagliv.databinding.FragmentHomeBindingImpl;
import com.app.swagliv.databinding.FragmentLikeBindingImpl;
import com.app.swagliv.databinding.FragmentMessageBindingImpl;
import com.app.swagliv.databinding.FragmentProfileBindingImpl;
import com.app.swagliv.databinding.ItemAddProductImagesBindingImpl;
import com.app.swagliv.databinding.ItemAdvertiseBindingImpl;
import com.app.swagliv.databinding.ItemCameraBindingImpl;
import com.app.swagliv.databinding.ItemChatBindingImpl;
import com.app.swagliv.databinding.ItemDataBindingImpl;
import com.app.swagliv.databinding.ItemGalleryBindingImpl;
import com.app.swagliv.databinding.ItemLikePictureBindingImpl;
import com.app.swagliv.databinding.ItemMyOrderBindingImpl;
import com.app.swagliv.databinding.ItemPorfolioBindingImpl;
import com.app.swagliv.databinding.ItemPriceBindingImpl;
import com.app.swagliv.databinding.ItemProductListingBindingImpl;
import com.app.swagliv.databinding.ItemPurchaseBindingImpl;
import com.app.swagliv.databinding.ItemSearchBindingImpl;
import com.app.swagliv.databinding.ItemShopBindingImpl;
import com.app.swagliv.databinding.ItemShoppingCartBindingImpl;
import com.app.swagliv.databinding.ItemShoppingForLoveBindingImpl;
import com.app.swagliv.databinding.ItemStoreBindingImpl;
import com.app.swagliv.databinding.ItemTinderBindingImpl;
import com.app.swagliv.databinding.ItemTrackcomplaintBindingImpl;
import com.app.swagliv.databinding.LayoutFilterBindingImpl;
import com.app.swagliv.databinding.RowLeftChatBindingImpl;
import com.app.swagliv.databinding.RowRightChatBindingImpl;
import com.app.swagliv.databinding.TopSheetBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADDPHONE = 1;

  private static final int LAYOUT_ACTIVITYADDPRODUCT = 2;

  private static final int LAYOUT_ACTIVITYADDPRODUCTIMAGES = 3;

  private static final int LAYOUT_ACTIVITYCHANGEPASSWORD = 4;

  private static final int LAYOUT_ACTIVITYCREATEADDRESS = 5;

  private static final int LAYOUT_ACTIVITYDASHBOAD = 6;

  private static final int LAYOUT_ACTIVITYDELIVERYADDRESS = 7;

  private static final int LAYOUT_ACTIVITYEDITADDRESS = 8;

  private static final int LAYOUT_ACTIVITYEDITINFORMATION = 9;

  private static final int LAYOUT_ACTIVITYEDITPROFILE = 10;

  private static final int LAYOUT_ACTIVITYEMAILSIGNIN = 11;

  private static final int LAYOUT_ACTIVITYFORGOTPASSWORD = 12;

  private static final int LAYOUT_ACTIVITYHELPANDFAQ = 13;

  private static final int LAYOUT_ACTIVITYIMAGEPREVIEWSCREEN = 14;

  private static final int LAYOUT_ACTIVITYINTRO = 15;

  private static final int LAYOUT_ACTIVITYLOCATIONGPSALLOWPERMISSION = 16;

  private static final int LAYOUT_ACTIVITYLOGIN = 17;

  private static final int LAYOUT_ACTIVITYMANAGECONNECTION = 18;

  private static final int LAYOUT_ACTIVITYMATCH = 19;

  private static final int LAYOUT_ACTIVITYMYORDER = 20;

  private static final int LAYOUT_ACTIVITYMYORDERDETAIL = 21;

  private static final int LAYOUT_ACTIVITYOTP = 22;

  private static final int LAYOUT_ACTIVITYPASSIONSELECTION = 23;

  private static final int LAYOUT_ACTIVITYPHONE = 24;

  private static final int LAYOUT_ACTIVITYPORTFOLIO = 25;

  private static final int LAYOUT_ACTIVITYPRODUCTLISTING = 26;

  private static final int LAYOUT_ACTIVITYPURCHASEHISTORY = 27;

  private static final int LAYOUT_ACTIVITYRESETPASSWORD = 28;

  private static final int LAYOUT_ACTIVITYSEARCHCRUSH = 29;

  private static final int LAYOUT_ACTIVITYSEARCHSCREEN = 30;

  private static final int LAYOUT_ACTIVITYSHOP = 31;

  private static final int LAYOUT_ACTIVITYSHOPPINGCART = 32;

  private static final int LAYOUT_ACTIVITYSHOPPINGFORLOVE = 33;

  private static final int LAYOUT_ACTIVITYSIDEBARSCREEN = 34;

  private static final int LAYOUT_ACTIVITYSIGNUP = 35;

  private static final int LAYOUT_ACTIVITYSPLASH = 36;

  private static final int LAYOUT_ACTIVITYSTORE = 37;

  private static final int LAYOUT_ACTIVITYSTOREPRODUCTDETAIL = 38;

  private static final int LAYOUT_ACTIVITYSUBSCRIPTION = 39;

  private static final int LAYOUT_ACTIVITYTOPSHEETAVTIVITY = 40;

  private static final int LAYOUT_ACTIVITYUSERPROFILE = 41;

  private static final int LAYOUT_ACTIVITYVERIFYOTP = 42;

  private static final int LAYOUT_ACTIVITYWALLET = 43;

  private static final int LAYOUT_ADAPTERADDRESS = 44;

  private static final int LAYOUT_APPCOMPLAINT = 45;

  private static final int LAYOUT_APPFEEDBACK = 46;

  private static final int LAYOUT_BOTTOMSHEETFILTER = 47;

  private static final int LAYOUT_BOTTOMSHEETSHOPPINGCART = 48;

  private static final int LAYOUT_BOTTOMSHEETSOMEONEELSESHOPPING = 49;

  private static final int LAYOUT_COMMONHEADER = 50;

  private static final int LAYOUT_COMMONHEADERV2 = 51;

  private static final int LAYOUT_FRAGMENTHOME = 52;

  private static final int LAYOUT_FRAGMENTLIKE = 53;

  private static final int LAYOUT_FRAGMENTMESSAGE = 54;

  private static final int LAYOUT_FRAGMENTPROFILE = 55;

  private static final int LAYOUT_ITEMADDPRODUCTIMAGES = 56;

  private static final int LAYOUT_ITEMADVERTISE = 57;

  private static final int LAYOUT_ITEMCAMERA = 58;

  private static final int LAYOUT_ITEMCHAT = 59;

  private static final int LAYOUT_ITEMDATA = 60;

  private static final int LAYOUT_ITEMGALLERY = 61;

  private static final int LAYOUT_ITEMLIKEPICTURE = 62;

  private static final int LAYOUT_ITEMMYORDER = 63;

  private static final int LAYOUT_ITEMPORFOLIO = 64;

  private static final int LAYOUT_ITEMPRICE = 65;

  private static final int LAYOUT_ITEMPRODUCTLISTING = 66;

  private static final int LAYOUT_ITEMPURCHASE = 67;

  private static final int LAYOUT_ITEMSEARCH = 68;

  private static final int LAYOUT_ITEMSHOP = 69;

  private static final int LAYOUT_ITEMSHOPPINGCART = 70;

  private static final int LAYOUT_ITEMSHOPPINGFORLOVE = 71;

  private static final int LAYOUT_ITEMSTORE = 72;

  private static final int LAYOUT_ITEMTINDER = 73;

  private static final int LAYOUT_ITEMTRACKCOMPLAINT = 74;

  private static final int LAYOUT_LAYOUTFILTER = 75;

  private static final int LAYOUT_ROWLEFTCHAT = 76;

  private static final int LAYOUT_ROWRIGHTCHAT = 77;

  private static final int LAYOUT_TOPSHEET = 78;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(78);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_add_phone, LAYOUT_ACTIVITYADDPHONE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_add_product, LAYOUT_ACTIVITYADDPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_add_product_images, LAYOUT_ACTIVITYADDPRODUCTIMAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_change_password, LAYOUT_ACTIVITYCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_create_address, LAYOUT_ACTIVITYCREATEADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_dashboad, LAYOUT_ACTIVITYDASHBOAD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_delivery_address, LAYOUT_ACTIVITYDELIVERYADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_edit_address, LAYOUT_ACTIVITYEDITADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_edit_information, LAYOUT_ACTIVITYEDITINFORMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_edit_profile, LAYOUT_ACTIVITYEDITPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_email_signin, LAYOUT_ACTIVITYEMAILSIGNIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_forgot_password, LAYOUT_ACTIVITYFORGOTPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_help_and_faq, LAYOUT_ACTIVITYHELPANDFAQ);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_image_preview_screen, LAYOUT_ACTIVITYIMAGEPREVIEWSCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_intro, LAYOUT_ACTIVITYINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_location_gpsallow_permission, LAYOUT_ACTIVITYLOCATIONGPSALLOWPERMISSION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_manage_connection, LAYOUT_ACTIVITYMANAGECONNECTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_match, LAYOUT_ACTIVITYMATCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_my_order, LAYOUT_ACTIVITYMYORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_my_order_detail, LAYOUT_ACTIVITYMYORDERDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_otp, LAYOUT_ACTIVITYOTP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_passion_selection, LAYOUT_ACTIVITYPASSIONSELECTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_phone, LAYOUT_ACTIVITYPHONE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_portfolio, LAYOUT_ACTIVITYPORTFOLIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_product_listing, LAYOUT_ACTIVITYPRODUCTLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_purchase_history, LAYOUT_ACTIVITYPURCHASEHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_reset_password, LAYOUT_ACTIVITYRESETPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_search_crush, LAYOUT_ACTIVITYSEARCHCRUSH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_search_screen, LAYOUT_ACTIVITYSEARCHSCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_shop, LAYOUT_ACTIVITYSHOP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_shopping_cart, LAYOUT_ACTIVITYSHOPPINGCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_shopping_for_love, LAYOUT_ACTIVITYSHOPPINGFORLOVE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_side_bar_screen, LAYOUT_ACTIVITYSIDEBARSCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_signup, LAYOUT_ACTIVITYSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_store, LAYOUT_ACTIVITYSTORE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_store_product_detail, LAYOUT_ACTIVITYSTOREPRODUCTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_subscription, LAYOUT_ACTIVITYSUBSCRIPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_top_sheet_avtivity, LAYOUT_ACTIVITYTOPSHEETAVTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_user_profile, LAYOUT_ACTIVITYUSERPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_verify_otp, LAYOUT_ACTIVITYVERIFYOTP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.activity_wallet, LAYOUT_ACTIVITYWALLET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.adapter_address, LAYOUT_ADAPTERADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.app_complaint, LAYOUT_APPCOMPLAINT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.app_feedback, LAYOUT_APPFEEDBACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.bottomsheet_filter, LAYOUT_BOTTOMSHEETFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.bottomsheet_shopping_cart, LAYOUT_BOTTOMSHEETSHOPPINGCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.bottomsheet_someone_else_shopping, LAYOUT_BOTTOMSHEETSOMEONEELSESHOPPING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.common_header, LAYOUT_COMMONHEADER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.common_header_v2, LAYOUT_COMMONHEADERV2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.fragment_like, LAYOUT_FRAGMENTLIKE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.fragment_message, LAYOUT_FRAGMENTMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_add_product_images, LAYOUT_ITEMADDPRODUCTIMAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_advertise, LAYOUT_ITEMADVERTISE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_camera, LAYOUT_ITEMCAMERA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_chat, LAYOUT_ITEMCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_data, LAYOUT_ITEMDATA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_gallery, LAYOUT_ITEMGALLERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_like_picture, LAYOUT_ITEMLIKEPICTURE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_my_order, LAYOUT_ITEMMYORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_porfolio, LAYOUT_ITEMPORFOLIO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_price, LAYOUT_ITEMPRICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_product_listing, LAYOUT_ITEMPRODUCTLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_purchase, LAYOUT_ITEMPURCHASE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_search, LAYOUT_ITEMSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_shop, LAYOUT_ITEMSHOP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_shopping_cart, LAYOUT_ITEMSHOPPINGCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_shopping_for_love, LAYOUT_ITEMSHOPPINGFORLOVE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_store, LAYOUT_ITEMSTORE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_tinder, LAYOUT_ITEMTINDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.item_trackcomplaint, LAYOUT_ITEMTRACKCOMPLAINT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.layout_filter, LAYOUT_LAYOUTFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.row_left_chat, LAYOUT_ROWLEFTCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.row_right_chat, LAYOUT_ROWRIGHTCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.app.swagliv.R.layout.top_sheet, LAYOUT_TOPSHEET);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYADDPHONE: {
        if ("layout/activity_add_phone_0".equals(tag)) {
          return new ActivityAddPhoneBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_add_phone is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYADDPRODUCT: {
        if ("layout/activity_add_product_0".equals(tag)) {
          return new ActivityAddProductBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_add_product is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYADDPRODUCTIMAGES: {
        if ("layout/activity_add_product_images_0".equals(tag)) {
          return new ActivityAddProductImagesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_add_product_images is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHANGEPASSWORD: {
        if ("layout/activity_change_password_0".equals(tag)) {
          return new ActivityChangePasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_change_password is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATEADDRESS: {
        if ("layout/activity_create_address_0".equals(tag)) {
          return new ActivityCreateAddressBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_address is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDASHBOAD: {
        if ("layout/activity_dashboad_0".equals(tag)) {
          return new ActivityDashboadBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_dashboad is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDELIVERYADDRESS: {
        if ("layout/activity_delivery_address_0".equals(tag)) {
          return new ActivityDeliveryAddressBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_delivery_address is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEDITADDRESS: {
        if ("layout/activity_edit_address_0".equals(tag)) {
          return new ActivityEditAddressBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_edit_address is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEDITINFORMATION: {
        if ("layout/activity_edit_information_0".equals(tag)) {
          return new ActivityEditInformationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_edit_information is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEDITPROFILE: {
        if ("layout/activity_edit_profile_0".equals(tag)) {
          return new ActivityEditProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_edit_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEMAILSIGNIN: {
        if ("layout/activity_email_signin_0".equals(tag)) {
          return new ActivityEmailSigninBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_email_signin is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFORGOTPASSWORD: {
        if ("layout/activity_forgot_password_0".equals(tag)) {
          return new ActivityForgotPasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_forgot_password is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYHELPANDFAQ: {
        if ("layout/activity_help_and_faq_0".equals(tag)) {
          return new ActivityHelpAndFaqBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_help_and_faq is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYIMAGEPREVIEWSCREEN: {
        if ("layout/activity_image_preview_screen_0".equals(tag)) {
          return new ActivityImagePreviewScreenBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_image_preview_screen is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYINTRO: {
        if ("layout/activity_intro_0".equals(tag)) {
          return new ActivityIntroBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_intro is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLOCATIONGPSALLOWPERMISSION: {
        if ("layout/activity_location_gpsallow_permission_0".equals(tag)) {
          return new ActivityLocationGpsallowPermissionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_location_gpsallow_permission is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLOGIN: {
        if ("layout/activity_login_0".equals(tag)) {
          return new ActivityLoginBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMANAGECONNECTION: {
        if ("layout/activity_manage_connection_0".equals(tag)) {
          return new ActivityManageConnectionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_manage_connection is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMATCH: {
        if ("layout/activity_match_0".equals(tag)) {
          return new ActivityMatchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_match is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYORDER: {
        if ("layout/activity_my_order_0".equals(tag)) {
          return new ActivityMyOrderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_order is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYORDERDETAIL: {
        if ("layout/activity_my_order_detail_0".equals(tag)) {
          return new ActivityMyOrderDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_order_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYOTP: {
        if ("layout/activity_otp_0".equals(tag)) {
          return new ActivityOtpBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_otp is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPASSIONSELECTION: {
        if ("layout/activity_passion_selection_0".equals(tag)) {
          return new ActivityPassionSelectionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_passion_selection is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPHONE: {
        if ("layout/activity_phone_0".equals(tag)) {
          return new ActivityPhoneBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_phone is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPORTFOLIO: {
        if ("layout/activity_portfolio_0".equals(tag)) {
          return new ActivityPortfolioBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_portfolio is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPRODUCTLISTING: {
        if ("layout/activity_product_listing_0".equals(tag)) {
          return new ActivityProductListingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_product_listing is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPURCHASEHISTORY: {
        if ("layout/activity_purchase_history_0".equals(tag)) {
          return new ActivityPurchaseHistoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_purchase_history is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRESETPASSWORD: {
        if ("layout/activity_reset_password_0".equals(tag)) {
          return new ActivityResetPasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_reset_password is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEARCHCRUSH: {
        if ("layout/activity_search_crush_0".equals(tag)) {
          return new ActivitySearchCrushBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_search_crush is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEARCHSCREEN: {
        if ("layout/activity_search_screen_0".equals(tag)) {
          return new ActivitySearchScreenBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_search_screen is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSHOP: {
        if ("layout/activity_shop_0".equals(tag)) {
          return new ActivityShopBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_shop is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSHOPPINGCART: {
        if ("layout/activity_shopping_cart_0".equals(tag)) {
          return new ActivityShoppingCartBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_shopping_cart is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSHOPPINGFORLOVE: {
        if ("layout/activity_shopping_for_love_0".equals(tag)) {
          return new ActivityShoppingForLoveBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_shopping_for_love is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSIDEBARSCREEN: {
        if ("layout/activity_side_bar_screen_0".equals(tag)) {
          return new ActivitySideBarScreenBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_side_bar_screen is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSIGNUP: {
        if ("layout/activity_signup_0".equals(tag)) {
          return new ActivitySignupBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_signup is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSPLASH: {
        if ("layout/activity_splash_0".equals(tag)) {
          return new ActivitySplashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSTORE: {
        if ("layout/activity_store_0".equals(tag)) {
          return new ActivityStoreBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_store is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSTOREPRODUCTDETAIL: {
        if ("layout/activity_store_product_detail_0".equals(tag)) {
          return new ActivityStoreProductDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_store_product_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSUBSCRIPTION: {
        if ("layout/activity_subscription_0".equals(tag)) {
          return new ActivitySubscriptionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_subscription is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYTOPSHEETAVTIVITY: {
        if ("layout/activity_top_sheet_avtivity_0".equals(tag)) {
          return new ActivityTopSheetAvtivityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_top_sheet_avtivity is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYUSERPROFILE: {
        if ("layout/activity_user_profile_0".equals(tag)) {
          return new ActivityUserProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_user_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYVERIFYOTP: {
        if ("layout/activity_verify_otp_0".equals(tag)) {
          return new ActivityVerifyOtpBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_verify_otp is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYWALLET: {
        if ("layout/activity_wallet_0".equals(tag)) {
          return new ActivityWalletBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_wallet is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERADDRESS: {
        if ("layout/adapter_address_0".equals(tag)) {
          return new AdapterAddressBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_address is invalid. Received: " + tag);
      }
      case  LAYOUT_APPCOMPLAINT: {
        if ("layout/app_complaint_0".equals(tag)) {
          return new AppComplaintBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for app_complaint is invalid. Received: " + tag);
      }
      case  LAYOUT_APPFEEDBACK: {
        if ("layout/app_feedback_0".equals(tag)) {
          return new AppFeedbackBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for app_feedback is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETFILTER: {
        if ("layout/bottomsheet_filter_0".equals(tag)) {
          return new BottomsheetFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottomsheet_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETSHOPPINGCART: {
        if ("layout/bottomsheet_shopping_cart_0".equals(tag)) {
          return new BottomsheetShoppingCartBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottomsheet_shopping_cart is invalid. Received: " + tag);
      }
      case  LAYOUT_BOTTOMSHEETSOMEONEELSESHOPPING: {
        if ("layout/bottomsheet_someone_else_shopping_0".equals(tag)) {
          return new BottomsheetSomeoneElseShoppingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bottomsheet_someone_else_shopping is invalid. Received: " + tag);
      }
      case  LAYOUT_COMMONHEADER: {
        if ("layout/common_header_0".equals(tag)) {
          return new CommonHeaderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for common_header is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_COMMONHEADERV2: {
        if ("layout/common_header_v2_0".equals(tag)) {
          return new CommonHeaderV2BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for common_header_v2 is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTHOME: {
        if ("layout/fragment_home_0".equals(tag)) {
          return new FragmentHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLIKE: {
        if ("layout/fragment_like_0".equals(tag)) {
          return new FragmentLikeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_like is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMESSAGE: {
        if ("layout/fragment_message_0".equals(tag)) {
          return new FragmentMessageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_message is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPROFILE: {
        if ("layout/fragment_profile_0".equals(tag)) {
          return new FragmentProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMADDPRODUCTIMAGES: {
        if ("layout/item_add_product_images_0".equals(tag)) {
          return new ItemAddProductImagesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_add_product_images is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMADVERTISE: {
        if ("layout/item_advertise_0".equals(tag)) {
          return new ItemAdvertiseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_advertise is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCAMERA: {
        if ("layout/item_camera_0".equals(tag)) {
          return new ItemCameraBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_camera is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMCHAT: {
        if ("layout/item_chat_0".equals(tag)) {
          return new ItemChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMDATA: {
        if ("layout/item_data_0".equals(tag)) {
          return new ItemDataBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_data is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMGALLERY: {
        if ("layout/item_gallery_0".equals(tag)) {
          return new ItemGalleryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_gallery is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMLIKEPICTURE: {
        if ("layout/item_like_picture_0".equals(tag)) {
          return new ItemLikePictureBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_like_picture is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMYORDER: {
        if ("layout/item_my_order_0".equals(tag)) {
          return new ItemMyOrderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_my_order is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPORFOLIO: {
        if ("layout/item_porfolio_0".equals(tag)) {
          return new ItemPorfolioBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_porfolio is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPRICE: {
        if ("layout/item_price_0".equals(tag)) {
          return new ItemPriceBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_price is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPRODUCTLISTING: {
        if ("layout/item_product_listing_0".equals(tag)) {
          return new ItemProductListingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_product_listing is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPURCHASE: {
        if ("layout/item_purchase_0".equals(tag)) {
          return new ItemPurchaseBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_purchase is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSEARCH: {
        if ("layout/item_search_0".equals(tag)) {
          return new ItemSearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_search is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSHOP: {
        if ("layout/item_shop_0".equals(tag)) {
          return new ItemShopBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_shop is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSHOPPINGCART: {
        if ("layout/item_shopping_cart_0".equals(tag)) {
          return new ItemShoppingCartBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_shopping_cart is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSHOPPINGFORLOVE: {
        if ("layout/item_shopping_for_love_0".equals(tag)) {
          return new ItemShoppingForLoveBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_shopping_for_love is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMSTORE: {
        if ("layout/item_store_0".equals(tag)) {
          return new ItemStoreBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_store is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMTINDER: {
        if ("layout/item_tinder_0".equals(tag)) {
          return new ItemTinderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_tinder is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMTRACKCOMPLAINT: {
        if ("layout/item_trackcomplaint_0".equals(tag)) {
          return new ItemTrackcomplaintBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_trackcomplaint is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYOUTFILTER: {
        if ("layout/layout_filter_0".equals(tag)) {
          return new LayoutFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for layout_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_ROWLEFTCHAT: {
        if ("layout/row_left_chat_0".equals(tag)) {
          return new RowLeftChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for row_left_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_ROWRIGHTCHAT: {
        if ("layout/row_right_chat_0".equals(tag)) {
          return new RowRightChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for row_right_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_TOPSHEET: {
        if ("layout/top_sheet_0".equals(tag)) {
          return new TopSheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for top_sheet is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.app.common.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(12);

    static {
      sKeys.put(1, "Subscription");
      sKeys.put(0, "_all");
      sKeys.put(2, "chats");
      sKeys.put(3, "comment");
      sKeys.put(4, "crushInfo");
      sKeys.put(5, "isForLocationPermission");
      sKeys.put(6, "passion");
      sKeys.put(7, "position");
      sKeys.put(8, "price");
      sKeys.put(9, "purchase");
      sKeys.put(10, "user");
      sKeys.put(11, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(78);

    static {
      sKeys.put("layout/activity_add_phone_0", com.app.swagliv.R.layout.activity_add_phone);
      sKeys.put("layout/activity_add_product_0", com.app.swagliv.R.layout.activity_add_product);
      sKeys.put("layout/activity_add_product_images_0", com.app.swagliv.R.layout.activity_add_product_images);
      sKeys.put("layout/activity_change_password_0", com.app.swagliv.R.layout.activity_change_password);
      sKeys.put("layout/activity_create_address_0", com.app.swagliv.R.layout.activity_create_address);
      sKeys.put("layout/activity_dashboad_0", com.app.swagliv.R.layout.activity_dashboad);
      sKeys.put("layout/activity_delivery_address_0", com.app.swagliv.R.layout.activity_delivery_address);
      sKeys.put("layout/activity_edit_address_0", com.app.swagliv.R.layout.activity_edit_address);
      sKeys.put("layout/activity_edit_information_0", com.app.swagliv.R.layout.activity_edit_information);
      sKeys.put("layout/activity_edit_profile_0", com.app.swagliv.R.layout.activity_edit_profile);
      sKeys.put("layout/activity_email_signin_0", com.app.swagliv.R.layout.activity_email_signin);
      sKeys.put("layout/activity_forgot_password_0", com.app.swagliv.R.layout.activity_forgot_password);
      sKeys.put("layout/activity_help_and_faq_0", com.app.swagliv.R.layout.activity_help_and_faq);
      sKeys.put("layout/activity_image_preview_screen_0", com.app.swagliv.R.layout.activity_image_preview_screen);
      sKeys.put("layout/activity_intro_0", com.app.swagliv.R.layout.activity_intro);
      sKeys.put("layout/activity_location_gpsallow_permission_0", com.app.swagliv.R.layout.activity_location_gpsallow_permission);
      sKeys.put("layout/activity_login_0", com.app.swagliv.R.layout.activity_login);
      sKeys.put("layout/activity_manage_connection_0", com.app.swagliv.R.layout.activity_manage_connection);
      sKeys.put("layout/activity_match_0", com.app.swagliv.R.layout.activity_match);
      sKeys.put("layout/activity_my_order_0", com.app.swagliv.R.layout.activity_my_order);
      sKeys.put("layout/activity_my_order_detail_0", com.app.swagliv.R.layout.activity_my_order_detail);
      sKeys.put("layout/activity_otp_0", com.app.swagliv.R.layout.activity_otp);
      sKeys.put("layout/activity_passion_selection_0", com.app.swagliv.R.layout.activity_passion_selection);
      sKeys.put("layout/activity_phone_0", com.app.swagliv.R.layout.activity_phone);
      sKeys.put("layout/activity_portfolio_0", com.app.swagliv.R.layout.activity_portfolio);
      sKeys.put("layout/activity_product_listing_0", com.app.swagliv.R.layout.activity_product_listing);
      sKeys.put("layout/activity_purchase_history_0", com.app.swagliv.R.layout.activity_purchase_history);
      sKeys.put("layout/activity_reset_password_0", com.app.swagliv.R.layout.activity_reset_password);
      sKeys.put("layout/activity_search_crush_0", com.app.swagliv.R.layout.activity_search_crush);
      sKeys.put("layout/activity_search_screen_0", com.app.swagliv.R.layout.activity_search_screen);
      sKeys.put("layout/activity_shop_0", com.app.swagliv.R.layout.activity_shop);
      sKeys.put("layout/activity_shopping_cart_0", com.app.swagliv.R.layout.activity_shopping_cart);
      sKeys.put("layout/activity_shopping_for_love_0", com.app.swagliv.R.layout.activity_shopping_for_love);
      sKeys.put("layout/activity_side_bar_screen_0", com.app.swagliv.R.layout.activity_side_bar_screen);
      sKeys.put("layout/activity_signup_0", com.app.swagliv.R.layout.activity_signup);
      sKeys.put("layout/activity_splash_0", com.app.swagliv.R.layout.activity_splash);
      sKeys.put("layout/activity_store_0", com.app.swagliv.R.layout.activity_store);
      sKeys.put("layout/activity_store_product_detail_0", com.app.swagliv.R.layout.activity_store_product_detail);
      sKeys.put("layout/activity_subscription_0", com.app.swagliv.R.layout.activity_subscription);
      sKeys.put("layout/activity_top_sheet_avtivity_0", com.app.swagliv.R.layout.activity_top_sheet_avtivity);
      sKeys.put("layout/activity_user_profile_0", com.app.swagliv.R.layout.activity_user_profile);
      sKeys.put("layout/activity_verify_otp_0", com.app.swagliv.R.layout.activity_verify_otp);
      sKeys.put("layout/activity_wallet_0", com.app.swagliv.R.layout.activity_wallet);
      sKeys.put("layout/adapter_address_0", com.app.swagliv.R.layout.adapter_address);
      sKeys.put("layout/app_complaint_0", com.app.swagliv.R.layout.app_complaint);
      sKeys.put("layout/app_feedback_0", com.app.swagliv.R.layout.app_feedback);
      sKeys.put("layout/bottomsheet_filter_0", com.app.swagliv.R.layout.bottomsheet_filter);
      sKeys.put("layout/bottomsheet_shopping_cart_0", com.app.swagliv.R.layout.bottomsheet_shopping_cart);
      sKeys.put("layout/bottomsheet_someone_else_shopping_0", com.app.swagliv.R.layout.bottomsheet_someone_else_shopping);
      sKeys.put("layout/common_header_0", com.app.swagliv.R.layout.common_header);
      sKeys.put("layout/common_header_v2_0", com.app.swagliv.R.layout.common_header_v2);
      sKeys.put("layout/fragment_home_0", com.app.swagliv.R.layout.fragment_home);
      sKeys.put("layout/fragment_like_0", com.app.swagliv.R.layout.fragment_like);
      sKeys.put("layout/fragment_message_0", com.app.swagliv.R.layout.fragment_message);
      sKeys.put("layout/fragment_profile_0", com.app.swagliv.R.layout.fragment_profile);
      sKeys.put("layout/item_add_product_images_0", com.app.swagliv.R.layout.item_add_product_images);
      sKeys.put("layout/item_advertise_0", com.app.swagliv.R.layout.item_advertise);
      sKeys.put("layout/item_camera_0", com.app.swagliv.R.layout.item_camera);
      sKeys.put("layout/item_chat_0", com.app.swagliv.R.layout.item_chat);
      sKeys.put("layout/item_data_0", com.app.swagliv.R.layout.item_data);
      sKeys.put("layout/item_gallery_0", com.app.swagliv.R.layout.item_gallery);
      sKeys.put("layout/item_like_picture_0", com.app.swagliv.R.layout.item_like_picture);
      sKeys.put("layout/item_my_order_0", com.app.swagliv.R.layout.item_my_order);
      sKeys.put("layout/item_porfolio_0", com.app.swagliv.R.layout.item_porfolio);
      sKeys.put("layout/item_price_0", com.app.swagliv.R.layout.item_price);
      sKeys.put("layout/item_product_listing_0", com.app.swagliv.R.layout.item_product_listing);
      sKeys.put("layout/item_purchase_0", com.app.swagliv.R.layout.item_purchase);
      sKeys.put("layout/item_search_0", com.app.swagliv.R.layout.item_search);
      sKeys.put("layout/item_shop_0", com.app.swagliv.R.layout.item_shop);
      sKeys.put("layout/item_shopping_cart_0", com.app.swagliv.R.layout.item_shopping_cart);
      sKeys.put("layout/item_shopping_for_love_0", com.app.swagliv.R.layout.item_shopping_for_love);
      sKeys.put("layout/item_store_0", com.app.swagliv.R.layout.item_store);
      sKeys.put("layout/item_tinder_0", com.app.swagliv.R.layout.item_tinder);
      sKeys.put("layout/item_trackcomplaint_0", com.app.swagliv.R.layout.item_trackcomplaint);
      sKeys.put("layout/layout_filter_0", com.app.swagliv.R.layout.layout_filter);
      sKeys.put("layout/row_left_chat_0", com.app.swagliv.R.layout.row_left_chat);
      sKeys.put("layout/row_right_chat_0", com.app.swagliv.R.layout.row_right_chat);
      sKeys.put("layout/top_sheet_0", com.app.swagliv.R.layout.top_sheet);
    }
  }
}
