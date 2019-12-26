package com.zues.mvvm_dagger2_sample.utils

import java.io.IOException

/* ---  Created by akhtarz on 12/5/2019. ---*/

class ApiException(message: String) : IOException(message)

class NoInternetException(message: String) : IOException(message)
