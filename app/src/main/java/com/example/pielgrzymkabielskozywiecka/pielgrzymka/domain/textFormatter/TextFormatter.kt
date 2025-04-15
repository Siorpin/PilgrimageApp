package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.textFormatter

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class TextFormatter(
    private val formats: List<Format>
) {
    private val formatterChar = '~'

    @Composable
    fun FormatText(
        text: String
    ) {
        cutTextToFormat(text, formats)


        return Text(text)
    }

    private fun cutTextToFormat(text: String, formats: List<Format>) {
        val paragraphs: MutableList<Pair<String, List<Format>>> = mutableListOf()
        // "papa~bpa~b"
        var index = 0
        var cutIndex = 0
        var skipNext = false

        for (i in 0..<text.length) {
            if (skipNext) {
                skipNext = false
                break
            }
            if (text[i] == formatterChar) {
                // add unformatted character
                paragraphs.add(
                    Pair(
                        text.substring(cutIndex, i),
                        emptyList()
                    )
                )
                skipNext = true
            }
        }
        text.forEach { char ->


            index++
        }


//        text.dropLast(1).forEach() { char ->
//            if (currentFormats.isNotEmpty()) {
//                if (char == formatterChar) {
//                    // checking if it's current format
//                    if (currentFormats.contains(text[index + 1])) {
//                        currentFormats.remove(text[index + 1])
//                        // TODO: Split formats
//                    } else {
//                        // Look for a new format
//                        formats.forEach { format ->
//                            if (text[index + 1] == format.formatSymbol) {
//                                currentFormats.add(format.formatSymbol)
//                            }
//                        }
//                    }
//                }
//            } else {
//                if (char == formatterChar) {
//                    formats.forEach{ format ->
//                        if (text[index + 1] == format.formatSymbol) {
//                            currentFormats.add(format.formatSymbol)
//                        }
//
//                    }
//                }
//            }
//
//            index++
//        }
    }

    private fun lookForFormat() {

    }
}