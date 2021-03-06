import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { OwnerRestController } from './web/rest/owner-rest.controller';
import { PetRestController } from './web/rest/pet-rest.controller';
import { PetTypeRestController } from './web/rest/pet-type-rest.controller';
import { SpecialtyRestController } from './web/rest/specialty-rest.controller';
import { VetRestController } from './web/rest/vet-rest.controller';
import { VisitRestController } from './web/rest/visit-rest.controller';
import { OwnerRestService } from './services/owner-rest.service';
import { PetRestService } from './services/pet-rest.service';
import { PetTypeRestService } from './services/pet-type-rest.service';
import { SpecialtyRestService } from './services/specialty-rest.service';
import { VetRestService } from './services/vet-rest.service';
import { VisitRestService } from './services/visit-rest.service';
import { ormconfig } from './orm.config';
import { OwnerRepository } from './repository/owner.repository';
import { PetRepository } from './repository/pet.repository';
import { PetTypeRepository } from './repository/pet-type.repository';
import { SpecialtyRepository } from './repository/specialty.repository';
import { VetRepository } from './repository/vet.repository';
import { VisitRepository } from './repository/visit.repository';
import { IntentIgnore, IntentMerge } from './intent/intent.decorators';

@IntentMerge()
@Module({
  imports: [
    TypeOrmModule.forRoot(ormconfig),
    TypeOrmModule.forFeature([OwnerRepository, PetRepository, PetTypeRepository, SpecialtyRepository, VetRepository, VisitRepository])
  ],
  controllers: [
    OwnerRestController,
    PetRestController,
    PetTypeRestController,
    SpecialtyRestController,
    VetRestController,
    VisitRestController
  ],
  providers: [
    OwnerRestService,
    PetRestService,
    PetTypeRestService,
    SpecialtyRestService,
    VetRestService,
    VisitRestService
  ]
})
export class AppModule {}