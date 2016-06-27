# Hakuna Matata Development IntelliJ / AS Plugin

#### Table of Contents

- <a href="#motivation">__Motivation__</a>
- <a href="#description">__Description__</a>
    - <a href="#live_templates">__Live templates__</a>
    - <a href="#postfix_autocompletions">__Postfix autocompletions__</a>
- <a href="#how_to">__How to use__</a>
- <a href="#references">__References__</a>
- <a href="#license">__License__</a>

<br>

<a name="motivation">
### Motivation

There are already a bunch of postfix completions for both IntelliJ / Android Studio, but this list could be
happily improved by adding more completions and templates to related libraries we use in our day to day. Moreover, the
easiest way to share live templates is by a plugin, not to copy manually all files in IntelliJ / Android Studio
configuration folder.

Whenever the repo reaches the final version, would be good to merge some of this completions to IntelliJ Community, but
first I wanted to give a try to all of you and improve/change/add some other completions and useful templates.

<br>

<a name="live_templates">
#### Live templates

__Plain extra__

- `prsf`: private static final

    ![](https://raw.githubusercontent.com/cesards/HakunaMatataIntelliJPlugin/master/art/prsf.gif?token=ABdwT6uJqHF7A2PWJ-eqYtyi4x8TBhTBks5XdoGxwA%3D%3D)

- `prsfi`: private static final int

    ![](https://raw.githubusercontent.com/cesards/HakunaMatataIntelliJPlugin/master/art/prsfi.gif?token=ABdwT90OQ-CAnlKoXATv6MuYKGVPPdklks5XdoHHwA%3D%3D)

- `prsfs`: private static final String

    ![](https://raw.githubusercontent.com/cesards/HakunaMatataIntelliJPlugin/master/art/prsfs.gif?token=ABdwT1cuDeC231vT2pzTqQUlwspTe6hCks5XdoHdwA%3D%3D)

__Other extra__

- `ifElse`: Inserts ''if else'' statement

    ![](https://raw.githubusercontent.com/cesards/HakunaMatataIntelliJPlugin/master/art/ifElse.gif?token=ABdwT1butDlatO1eJK-SdDgEmSDklrmvks5XdoErwA%3D%3D)

__Timber__

(Basically offers the same functionality as the android log live templates)

- `time`: Timber.e(exception, String)

- `timd`: Timber.d(String)

- `timv`: Timber.v(String)

- `timm`: Log method name and its arguments

- `timw`: Timber.w(Exception, String)

- `timi`: Timber.i(String)

- `timr`: Log result of this method

- `timwtf`: Timber.wtf(Exception, String)

__Easter Egg__

- `trolling` (not working yet)

<a name="postfix_autocompletions">
### Postfix autocompletions

__Java__

- `newInstanceWithAssignment`:

- `newInstanceReplacement`

- `emptyCheck`

- `ifElse`

- `ifElseIf`

__Asserts__

- `assertEquals`:

- `assertNotEquals`:

- `assertSame`:

- `assertNotSame`:

- `assertThat`:

- `assertTrue`:

- `assertFalse`:



__Mockito__

- `whenThen`

- `whenThenCallRealMethod`

- `whenThenAnswer`

- `whenThenReturn`

- `whenThenThrow`

- `verify`

- `verifyNoMoreInteractions`

- `verifyZeroInteractions`

- `doNothingWhen`

- `doReturnWhen`

- `doThrowWhen`

- `mock`


<br>

<a name="how_to">
### How to use


<br>

<a name="references">
### References

- [__keyboardsurfer idea-live-templates__](https://github.com/keyboardsurfer/idea-live-templates)
- [__Sharing Live Templates Creating and Editing Template Variables__](https://www.jetbrains.com/help/idea/2016.1/creating-and-editing-template-variables.html)






















## Description

Set of live templates and postfix completions that will make your development life easier

### Motivation



## Already existing live templates

These are some of the most important ones (not resource related):

### Android


| Android           | AndroidLog | AndroidParcelable      | iterations | other | output | plain |
| ----------------- | ---------- | ---------------------- | ---------- | ----- | ------ | ----- |
| const             | logd       | Parcelable             | fori       | geti  | serr   | psf   |
| foreach           | loge       | ParcelableEnum         | itar       | ifn   | souf   | psfi  |
| gone              | logi       | ParcelableEnumTest     | itco       | inn   | sout   | psfs  |
| IntentView        | logm       | ParcelBoolean          | iten       | inst  | soutm  | St    |
| key               | logr       | UnparcelBoolean        | iter       | lazy  | soutp  | thr   |
| newInstance       | logt       | UnparcelIntArray       | itit       | last  | soutv  |       |
| noInstance        | logw       | UnparcelStringArray    | itli       | mn    |
| rgS               | wtf        |                        | ittok      | mx    |
| rouiT             |            |                        | itve       | psvm  |
| sbc               |            |                        | ritar      | toar  |
| Sfmt              |            |
| starter           |            |
| Toast             |            |
| ViewConstructors  |            |
| visible           |
| wrapIt            |





## References

- `const`: Define android style int constant
    - Applicable in Java: __declaration__
    ```java
    private static final int $name$ = $value$;
    ```
- `fbc`: `findViewById` with cast
    - Applicable in Java: __statement__
    ```java
    ($cast$) findViewById(R.id.$resId$);
    ```
- `foreach`: Create a for each loop
    - Applicable in Java: __statement__
    ```
    for ($i$ : $data$) {
        $cursor$
    }
    ```
- `gone`: Set view visibility to `GONE`
    - Applicable in Java: __statement__
    ```
    $VIEW$.setVisibility(android.view.View.GONE);
    ```
- `IntentView`: Creates an Intent with ACTION_VIEW`
    - Applicable in Java: __statement__
    ```java
    android.content.Intent view = new Intent();
    view.setAction(Intent.ACTION_VIEW);
    view.setData(android.net.Uri.parse($url$));
    startActivity(view);
    ```
- `key`: Key for a bundle
    - Applicable in Java: __declaration__
    ```java
    private static final String KEY_$value$ = "$value$";
    ```
- `newInstance`: create a new Fragment instance with arguments
    - Applicable in Java: __declaration__
    ```java
    public static $fragment$ newInstance($args$) {
        $nullChecks$
        android.os.Bundle args = new Bundle();
        $addArgs$
        $fragment$ fragment = new $fragment$();
        fragment.setArguments(args);
        return fragment;
    }
    ```
- `noInstance`: private empty constructor to prohibit instance creation
    - Applicable in Java: __declaration__
    ```java
    private $class$() {
        //no instance
    }
    ```
- `rgS`: get a `String` from resources
    - Applicable in Java: __statement__, __expression__
    ```java
    $resources$.getString(R.string.$stringId$)
    ```
- `rouiT`: `runOnUIThread`
    - Applicable in Java: __statement__
    ```java
    getActivity().runOnUiThread(new java.lang.Runnable() {
        @Override
        public void run() {
            $cursor$
        }
    });
    ```
- `sbc`:
    - Applicable in Java: __declaration__
    ```java
    ///////////////////////////////////////////////////////////////////////////
    // $blockName$
    ///////////////////////////////////////////////////////////////////////////
    ```
- `Sfmt`: `String` format
    - Applicable in Java: __statement__, __expression__
    ```java
    String.format("$string$", $params$);
    ```
- `starter`: Creates a static `start(...)` helper method to start an `Activity`
    - Applicable in Java: __declaration__
    ```java
    public static void start(android.content.Context context) {
        android.content.Intent starter = new Intent(context, $ACTIVITY$.class);
        starter.putExtra($CURSOR$);
        context.startActivity(starter);
    }
    ```
- `Toast`: Create a new `Toast`
    - Applicable in Java: __statement__
    ```java
    android.widget.Toast.makeText($className$.this, "$text$", Toast.LENGTH_SHORT).show();
    ```
- `ViewConstructors`: Adds generic view constructors
    - Applicable in Java: __declaration__
    ```java
    public $class$(android.content.Context context) {
        this(context, null);
    }

    public $class$(Context context, android.util.AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public $class$(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        $cursor$
    }
    ```
- `visible`: Set view visibility to `VISIBLE`
    - Applicable in Java: __statement__
    ```
    $VIEW$.setVisibility(View.VISIBLE);
    ```

- `wrapIt`: adds a gradle wrapper task
    - Applicable in Java: __declaration__
    ```java
    task wrapper(type: Wrapper) {
        gradleVersion = "$version$"
    }
    ```







## https://github.com/keyboardsurfer/idea-live-templates




.new	Produces instantiation expression for type	new SomeType()
.empty  TextUtils.isEmpty()  //only for strings
