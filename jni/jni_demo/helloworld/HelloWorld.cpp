#include <iostream>
#include "HelloWorld.h"

using namespace std;

JNIEXPORT void JNICALL Java_Hello_print(JNIEnv *e, jobject obj) {
    cout << "Hello World printed from C++";
}