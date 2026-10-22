package com.example.pertemuan6.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults.Thickness
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.pertemuan6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    OnSubmitBtnClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Form Isian", color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. Input Nama Lengkap
            OutlinedTextField(
                value = "",
                onValueChange = {},
                singleLine = true,
                modifier = Modifier
                    .padding(top = 40.dp)
                    .width(280.dp),
                label = { Text(text = "Nama Lengkap") }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 2. Baris Pilihan Jenis Kelamin (Hanya perulangan RadioButton di sini)
            Row(
                modifier = Modifier.width(280.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                jenisK.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = false, // Status klik belum diaktifkan
                            onClick = { /* TODO: state */ }
                        )
                        Text(text = item)
                    }
                }
            }

            // 3. Garis Pembatas
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .width(280.dp),
                thickness = 1.dp,
                color = Color.Gray
            )

            // 4. Input Alamat (Sudah dikeluarkan dari perulangan)
            OutlinedTextField(
                value = "",
                onValueChange = {},
                singleLine = true,
                modifier = Modifier.width(280.dp),
                label = { Text(text = "Alamat") }
            )

            Spacer(modifier = Modifier.height(40.dp))

            // 5. Tombol Submit (Sudah dikeluarkan dari perulangan)
            Button(
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp),
                onClick = OnSubmitBtnClick
            ) {
                Text(text = "Submit")
            }
        }
    }
}