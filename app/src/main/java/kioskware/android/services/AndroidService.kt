package kioskware.android.services

import android.app.ActivityManager
import android.app.AlarmManager
import android.app.DownloadManager
import android.app.KeyguardManager
import android.app.NotificationManager
import android.app.SearchManager
import android.app.WallpaperManager
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.app.usage.NetworkStatsManager
import android.app.usage.UsageStatsManager
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.companion.CompanionDeviceManager
import android.content.ClipboardManager
import android.content.Context
import android.content.RestrictionsManager
import android.content.SharedPreferences
import android.content.pm.ShortcutManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.fingerprint.FingerprintManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.PowerManager
import android.os.UserManager
import android.os.Vibrator
import android.os.VibratorManager
import android.os.storage.StorageManager
import android.print.PrintManager
import android.telephony.CarrierConfigManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.telephony.euicc.EuiccManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.inputmethod.InputMethodManager
import android.view.textclassifier.TextClassificationManager
import android.view.textservice.TextServicesManager
import androidx.annotation.RequiresApi

/**
 * Provides access to various Android system services in a type-safe manner.
 */
object AndroidService {

    /**
     * Retrieves the [android.app.admin.DevicePolicyManager] system service.
     * This service allows you to manage device policies and security features.
     */
    val devicePolicyManager get() = AppContext.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

    /**
     * Retrieves the [android.net.wifi.WifiManager] system service.
     * This service allows you to manage Wi-Fi connectivity and configurations.
     */
    val wifiManager get() = AppContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

    /**
     * Retrieves the [android.net.ConnectivityManager] system service.
     * This service allows you to manage network connections and monitor connectivity status.
     */
    val connectivityManager get() = AppContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    /**
     * Retrieves the [android.os.PowerManager] system service.
     * This service allows you to manage power-related features and device wake states.
     */
    val powerManager get() = AppContext.getSystemService(Context.POWER_SERVICE) as PowerManager

    /**
     * Retrieves the [android.app.NotificationManager] system service.
     * This service allows you to manage and display notifications.
     */
    val notificationManager get() = AppContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    /**
     * Retrieves the [android.app.ActivityManager] system service.
     * This service allows you to manage and interact with activities and tasks.
     */
    val activityManager get() = AppContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

    /**
     * Retrieves the [android.view.inputmethod.InputMethodManager] system service.
     * This service allows you to manage input methods and keyboards.
     */
    val inputMethodManager get() = AppContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    /**
     * Retrieves the [android.view.WindowManager] system service.
     * This service allows you to manage the display and windows on the device.
     */
    val windowManager get() = AppContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager

    /**
     * Retrieves the [android.app.AlarmManager] system service.
     * This service allows you to schedule and manage alarms.
     */
    val alarmManager get() = AppContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    /**
     * Retrieves the [android.content.ClipboardManager] system service.
     * This service allows you to manage clipboard operations.
     */
    val clipboardManager get() = AppContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    /**
     * Retrieves the [android.location.LocationManager] system service.
     * This service allows you to manage location providers and access location data.
     */
    val locationManager get() = AppContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    /**
     * Retrieves the [android.hardware.SensorManager] system service.
     * This service allows you to access and manage device sensors.
     */
    val sensorManager get() = AppContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    /**
     * Retrieves the [android.media.AudioManager] system service.
     * This service allows you to manage audio settings and control audio output.
     */
    val audioManager get() = AppContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    /**
     * Retrieves the [android.app.KeyguardManager] system service.
     * This service allows you to manage keyguard and lock screen features.
     */
    val keyguardManager get() = AppContext.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

    /**
     * Retrieves the [android.app.SearchManager] system service.
     * This service allows you to manage search-related features and configurations.
     */
    val searchManager get() = AppContext.getSystemService(Context.SEARCH_SERVICE) as SearchManager

    /**
     * Retrieves the [android.os.Vibrator] system service.
     * This service allows you to control the device's vibration capabilities.
     */
    @Deprecated("Use vibratorManager on API 31 and above instead.")
    val vibrator get() = AppContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    /**
     * Retrieves the [android.os.VibratorManager] system service.
     * This service allows you to manage multiple vibrator devices on the system.
     * Requires API level 31 (Android 12) or higher.
     */
    @get:RequiresApi(Build.VERSION_CODES.S)
    val vibratorManager get() =
        AppContext.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager

    /**
     * Retrieves the [android.telephony.TelephonyManager] system service.
     * This service allows you to manage telephony features and access telephony information.
     */
    val telephonyManager get() = AppContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

    /**
     * Retrieves the [android.hardware.usb.UsbManager] system service.
     * This service allows you to manage USB devices and connections.
     */
    val usbManager get() = AppContext.getSystemService(Context.USB_SERVICE) as UsbManager

    /**
     * Retrieves the [android.bluetooth.BluetoothManager] system service.
     * This service allows you to manage Bluetooth connectivity and configurations.
     */
    val bluetoothManager get() = AppContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

    /**
     * Retrieves the [android.app.job.JobScheduler] system service.
     * This service allows you to schedule jobs that will be executed in the background.
     */
    val jobScheduler get() = AppContext.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

    /**
     * Retrieves the [android.media.projection.MediaProjectionManager] system service.
     * This service allows you to capture screen content and record the device's display.
     */
    val mediaProjectionManager get() = AppContext.getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

    /**
     * Retrieves the [android.media.session.MediaSessionManager] system service.
     * This service allows you to manage media sessions and control media playback.
     */
    val mediaSessionManager get() = AppContext.getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager

    /**
     * Retrieves the [android.hardware.camera2.CameraManager] system service.
     * This service allows you to manage camera devices and access camera features.
     */
    val cameraManager get() = AppContext.getSystemService(Context.CAMERA_SERVICE) as CameraManager

    /**
     * Retrieves the [android.hardware.fingerprint.FingerprintManager] system service.
     * This service allows you to manage fingerprint authentication and access fingerprint features.
     */
    @Deprecated("FingerprintManager is deprecated in API level 28. Use BiometricPrompt instead.")
    val fingerprintManager get() = AppContext.getSystemService(Context.FINGERPRINT_SERVICE) as FingerprintManager

    /**
     * Retrieves the [android.view.accessibility.AccessibilityManager] system service.
     * This service allows you to manage accessibility features and configurations.
     */
    val accessibilityManager get() = AppContext.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

    /**
     * Retrieves the [android.appwidget.AppWidgetManager] system service.
     * This service allows you to manage app widgets and their configurations.
     */
    val appWidgetManager get() = AppContext.getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

    /**
     * Retrieves the [android.app.DownloadManager] system service.
     * This service allows you to manage and monitor downloads.
     */
    val downloadManager get() = AppContext.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

    /**
     * Retrieves the [AlarmManager] system service.
     * This service allows you to schedule and manage alarms.
     */
    val storageManager get() = AppContext.getSystemService(Context.STORAGE_SERVICE) as StorageManager

    /**
     * Retrieves the [android.app.WallpaperManager] system service.
     * This service allows you to manage and set wallpapers.
     */
    val wallpaperManager get() = AppContext.getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager

    /**
     * Retrieves the [android.view.LayoutInflater] system service.
     * This service allows you to instantiate layout XML files into their corresponding View objects.
     */
    val layoutInflater get() = AppContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    /**
     * Retrieves the [android.content.pm.ShortcutManager] system service.
     * This service allows you to manage app shortcuts.
     */
    val shortcutManager @RequiresApi(Build.VERSION_CODES.N_MR1)
    get() = AppContext.getSystemService(Context.SHORTCUT_SERVICE) as ShortcutManager

    /**
     * Retrieves the [android.os.UserManager] system service.
     * This service allows you to manage user accounts and profiles on the device.
     */
    val userManager get() = AppContext.getSystemService(Context.USER_SERVICE) as UserManager

    /**
     * Retrieves the [android.print.PrintManager] system service.
     * This service allows you to manage printing tasks and print services.
     */
    val printManager get() = AppContext.getSystemService(Context.PRINT_SERVICE) as PrintManager

    /**
     * Retrieves the [android.hardware.input.InputManager] system service.
     * This service allows you to manage input devices and their configurations.
     */
    val inputManager get() = AppContext.getSystemService(Context.INPUT_SERVICE) as InputManager

    /**
     * Retrieves the [android.view.textclassifier.TextClassificationManager] system service.
     * This service allows you to manage text classification and related features.
     */
    val textClassificationManager @RequiresApi(Build.VERSION_CODES.O)
    get() = AppContext.getSystemService(Context.TEXT_CLASSIFICATION_SERVICE) as TextClassificationManager

    /**
     * Retrieves the [android.telephony.CarrierConfigManager] system service.
     * This service allows you to access carrier-specific configuration values.
     */
    val carrierConfigManager get() = AppContext.getSystemService(Context.CARRIER_CONFIG_SERVICE) as CarrierConfigManager

    /**
     * Retrieves the [android.companion.CompanionDeviceManager] system service.
     * This service allows you to manage companion devices associated with the app.
     */
    val companionDeviceManager @RequiresApi(Build.VERSION_CODES.O)
    get() = AppContext.getSystemService(Context.COMPANION_DEVICE_SERVICE) as CompanionDeviceManager

    /**
     * Retrieves the [android.content.RestrictionsManager] system service.
     * This service allows you to manage application restrictions imposed by device administrators.
     */
    val restrictionsManager get() = AppContext.getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager

    /**
     * Retrieves the [android.media.tv.TvInputManager] system service.
     * This service allows you to manage TV input services and related features.
     */
    val tvInputManager get() = AppContext.getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager

    /**
     * Retrieves the [android.telephony.SubscriptionManager] system service.
     * This service allows you to manage telephony subscriptions and related information.
     */
    val subscriptionManager get() = AppContext.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager

    /**
     * Retrieves the [android.telephony.euicc.EuiccManager] system service.
     * This service allows you to manage eSIM profiles and related features.
     */
    val euiccManager @RequiresApi(Build.VERSION_CODES.P)
    get() = AppContext.getSystemService(Context.EUICC_SERVICE) as EuiccManager

    /**
     * Retrieves the [android.app.usage.NetworkStatsManager] system service.
     * This service allows you to access network usage statistics and related information.
     */
    val networkStatsManager get() = AppContext.getSystemService(Context.NETWORK_STATS_SERVICE) as NetworkStatsManager

    /**
     * Retrieves the [android.app.usage.UsageStatsManager] system service.
     * This service allows you to access app usage statistics and related information.
     */
    val usageStatsManager get() = AppContext.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

    /**
     * Retrieves the [android.view.textservice.TextServicesManager] system service.
     * This service allows you to manage text services such as spell checking and input methods.
     */
    val textServicesManager get() = AppContext.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager

    /**
     * Creates or retrieves a SharedPreferences instance.
     * This is used to store key-value pairs in a persistent manner.
     */
    fun sharedPreferences(name: String, mode: Int = Context.MODE_PRIVATE): SharedPreferences {
        return AppContext.getSharedPreferences(name, mode)
    }

    /**
     * Lazily initializes a SharedPreferences instance.
     *
     * @param name The name of the preferences file.
     * @param mode The operating mode (default is Context.MODE_PRIVATE).
     * @return A lazy instance of SharedPreferences.
     */
    fun lazySharedPreferences(name: String, mode: Int = Context.MODE_PRIVATE): Lazy<SharedPreferences> {
        return lazy { AppContext.getSharedPreferences(name, mode) }
    }

}